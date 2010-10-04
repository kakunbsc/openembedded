DESCRIPTION = "Vuplus: madwifi Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-vuplus-madwifi
#
DESCRIPTION_${PN} = "Vuplus: madwifi Support"
DEPENDS_${PN} = "\
  madwifi-ng \
"

RDEPENDS_${PN} = "\
  madwifi-ng-modules \
"

