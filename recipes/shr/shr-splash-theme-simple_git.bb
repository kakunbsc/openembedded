DESCRIPTION = "SHR splash screen - simple SHR theme"
SECTION = "x11/data"
LICENSE = "MIT BSD"
PV = "1.2+gitr${SRCREV}"
PR = "r6"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"
S = "${WORKDIR}/git/shr-splash/${PN}"

ALTERNATIVE_PRIORITY = 2

require shr-splash-theme.inc

