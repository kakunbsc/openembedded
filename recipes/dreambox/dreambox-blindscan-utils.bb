DESCRIPTION = "Utilities needed to do transponder blindscan with dreambox dvb receivers"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"
RDEPENDS = "ncurses"
PV = "1.0"
PV_dm600pvr = "1.1"
PV_mipsel = "1.1"
PR = "r0"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "http://sources.dreamboxupdate.com/download/opendreambox/dreambox-blindscan-utils-${MACHINE}-${PV}.tar.bz2"
SRC_URI_vuplus = "http://sources.dreamboxupdate.com/download/opendreambox/dreambox-blindscan-utils-dm8000-${PV}.tar.bz2"

S = "${WORKDIR}/blindscan-utils"

do_install() {
	install -d ${D}/${bindir}/
	for i in `find ${S} -type f -maxdepth 1`; do
		install -m 0755 $i ${D}/${bindir}/;
	done;
}
