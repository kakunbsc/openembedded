DESCRIPTION = "Vuplus: DVD-Player Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-vuplus-dvdplayer
#
DESCRIPTION_${PN} = "Vuplus: DVD-Player Support"
DEPENDS_${PN} = "enigma2
RDEPENDS_${PN} = "\
  kernel-module-udf \
  kernel-module-isofs \
  enigma2-plugin-extensions-dvdplayer \
"

