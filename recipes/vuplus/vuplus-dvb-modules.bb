DESCRIPTION = "Hardware drivers for VuPlus"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"


def get_modules_extension(bb, d):
	if bb.data.getVar('GLIBC_ADDONS', d, 1) in ['nptl']:
		return "-gcc4.1"
	return ""

KV = "2.6.18-7.3"


PV_bm750 = "${KV}"
PV_vusolo = "${KV}"


SRCDATE_bm750 = "20100927"
SRCDATE_vusolo = "20100927"


RDEPENDS = "initscripts-vuplus kernel (${KV}) kernel-module-firmware-class kernel-module-input kernel-module-evdev kernel-module-i2c-core kernel-module-snd kernel-module-snd-pcm"
PR = "r19-${SRCDATE}"

SRC_URI = "http://archive.vuplus.com/download/drivers/mbox-dvb-modules-${MACHINE}-${PV}-${PREFERRED_GCC_VERSION}-${SRCDATE}.tar.gz "

S = "${WORKDIR}"

do_install() {
        install -d ${D}/lib/modules/${KV}/extra
        for f in *.ko; do
                install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KV}/extra/$f;
        done
}



PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
