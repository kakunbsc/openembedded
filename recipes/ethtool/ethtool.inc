DESCRIPTION = "A small utility for examining and tuning the settings \
of your ethernet-based network interfaces."
HOMEPAGE = "http://sourceforge.net/projects/gkernel/"
SECTION = "console/network"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/gkernel/ethtool-${PV}.tar.gz"

SRC_URI_append_vuplus = " \
		file://ethtool_vuplus.patch;patch=1"

inherit autotools
