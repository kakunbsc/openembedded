DESCRIPTION = "Vuplus: DVD-Burn Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-vuplus-dvdburn
#
DESCRIPTION_${PN} = "Vuplus: DVD-Burning Support"
DEPENDS_${PN} = "enigma2"
RDEPENDS_${PN} = "\
  cdrkit \
  dvd+rw-tools \
  dvdauthor \
  enigma2-plugin-extensions-dvdburn \
  mjpegtools \
  projectx \
  python-imaging \
"

