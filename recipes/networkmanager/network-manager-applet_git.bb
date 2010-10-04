DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "libnotify networkmanager dbus-glib libglade gconf gnome-keyring"
RDEPENDS = "networkmanager"

DEFAULT_PREFERENCE = "-1"

SRCREV = "efa170820623e7c1d6c161bfc8a37db0d074d09e"
PV = "0.7.1+git"
PR_append = ".gitr${SRCREV}"

inherit gnome

SRC_URI = "git://git.gnome.org/network-manager-applet;protocol=git;branch=NETWORKMANAGER_APPLET_0_7 \
file://nm-applet.conf"

S = "${WORKDIR}/git"

# Hack around dbus a_console problems
do_install_append() {
	install -m 0644 ${WORKDIR}/nm-applet.conf ${D}${sysconfdir}/dbus-1/system.d/
}

FILES_${PN} += "${datadir}/nm-applet/ \
        ${datadir}/gnome-vpn-properties/ \
        ${datadir}/gnome/autostart/ \
        "
