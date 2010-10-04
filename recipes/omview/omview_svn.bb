DESCRIPTION = "OMView"
SECTION = "x11/graphics"
PKG_TAGS_${PN} = "group::communication"
DEPENDS += " evas ewl epsilon"
RDEPENDS += " epsilon-thumbd"
PV = "0.0.1+svnr${SRCPV}"
PR = "r2"

inherit autotools

SRC_URI += "svn://svn.projects.openmoko.org/svnroot;proto=svn;module=omview"

S = "${WORKDIR}/${PN}"

