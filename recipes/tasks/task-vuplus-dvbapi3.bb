DESCRIPTION = "Vuplus: DVB API v3 Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r0"

inherit task

PROVIDES = "\
  task-vuplus-dvbapi \
  ${PACKAGES}\
"

#
# task-vuplus-dvbapi3
#
RPROVIDES_${PN} = "task-vuplus-dvbapi"
DESCRIPTION_${PN} = "Vuplus: DVB API v3 Dependencies"
RDEPENDS_${PN} = "\
  dvbsnoop \
  vuplus-dvb-tools \
  dvbtraffic \
  sctzap \
 "

