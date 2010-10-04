DESCRIPTION="AiO screen grabber for dreambox stbs"
LICENSE = "GPL"

PR = "r0"
PV = "0.8+cvs${SRCDATE}"
SRCDATE = "20100220"

PR_vuplus = "r1"
PV_vuplus = "0.8cvs${SRCDATE}"
SRCDATE_vuplus = "20090625"
SRC_URI="cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/aio-grab;module=aio-grab;method=pserver"
SRC_URI_append_vuplus = "\
	file://aio-grab_vuplus.patch;patch=1"

S = "${WORKDIR}/aio-grab"

inherit autotools pkgconfig
