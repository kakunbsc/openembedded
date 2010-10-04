DESCRIPTION = "Volume Control Applet for GPE"
LICENSE = "GPL"
SECTION = "gpe"

DEPENDS = "libgpewidget"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe autotools

SRC_URI += "file://setlocale.patch;patch=1"
