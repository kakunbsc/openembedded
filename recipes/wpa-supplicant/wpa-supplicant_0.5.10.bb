DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
SECTION = "network"
LICENSE = "GPL"
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
DEPENDS = "gnutls ${@base_contains("COMBINED_FEATURES", "madwifi", "madwifi-ng", "",d)}"

PR = "r1"

#we introduce MY_ARCH to get 'armv5te' as arch instead of the misleading 'arm' on armv5te builds
MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('COMBINED_FEATURES', 'madwifi', '${MACHINE_ARCH}', '${MY_ARCH}', d)}"

SRC_URI = "http://hostap.epitest.fi/releases/wpa_supplicant-${PV}.tar.gz \
	file://defconfig-gnutls \
	file://ifupdown.sh \
	file://functions.sh"

SRC_URI_append_opendreambox = " \
	file://driver-zydas.patch;patch=1 \
	file://driver-ralink.patch;patch=1"

DEPENDS_dm8000_append = "madwifi-ng"
TARGET_CFLAGS_dm8000_append = " -I${STAGING_INCDIR}/madwifi-ng"

S = "${WORKDIR}/wpa_supplicant-${PV}"

PACKAGES_prepend = "wpa-supplicant-passphrase "
FILES_wpa-supplicant-passphrase = "/usr/sbin/wpa_passphrase"

RREPLACES = "wpa-supplicant-cli"

RRECOMMENDS_${PN} = "wpa-supplicant-passphrase"

export HAS_MADWIFI = "${@base_contains('COMBINED_FEATURES', 'madwifi', 1, 0,d)}"

do_configure () {
        install -m 0755 ${WORKDIR}/defconfig-gnutls  .config

        if [ "x$HAS_MADWIFI" == "x1" ] ; then
                echo "CONFIG_DRIVER_MADWIFI=y" >> .config
                echo "CFLAGS += -I${STAGING_INCDIR}/madwifi-ng" >> .config
        fi
}

do_configure_append_opendreambox() {
	echo "CONFIG_DRIVER_RALINK=y" >> .config
	echo "CONFIG_DRIVER_ZYDAS=y" >> .config
}

do_compile () {
	make
}

do_install () {
	install -d ${D}${sbindir}
	install -m 755 wpa_supplicant ${D}${sbindir}
	install -m 755 wpa_passphrase ${D}${sbindir}
	install -m 755 wpa_cli        ${D}${sbindir}

	install -d ${D}${localstatedir}/run/wpa_supplicant

	install -d ${D}${docdir}/wpa_supplicant
	install -m 644 README ${D}${docdir}/wpa_supplicant

	install -d ${D}${sysconfdir}/network/if-pre-up.d/
	install -d ${D}${sysconfdir}/network/if-post-down.d/
	install -d ${D}${sysconfdir}/network/if-down.d/

	install -d ${D}${sysconfdir}/wpa_supplicant
	install -m 755 ${WORKDIR}/ifupdown.sh ${D}${sysconfdir}/wpa_supplicant/
	install -m 755 ${WORKDIR}/functions.sh ${D}${sysconfdir}/wpa_supplicant
	
	ln -s /etc/wpa_supplicant/ifupdown.sh ${D}${sysconfdir}/network/if-pre-up.d/wpasupplicant
	ln -s /etc/wpa_supplicant/ifupdown.sh ${D}${sysconfdir}/network/if-post-down.d/wpasupplicant
}
