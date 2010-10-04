DESCRIPTION = "Vuplus: CD-Player Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-vuplus-cdplayer
#
DESCRIPTION_${PN} = "Vuplus: CD-Player Support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
 kernel-module-cdfs \
 enigma2-plugin-extensions-cdinfo \
 libcddb \
 libcdio \
"

