DESCRIPTION = "Vuplus: W-LAN Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r3"

inherit task

#
# task-vuplus-wlan
#
DESCRIPTION_${PN} = "Vuplus: W-LAN Support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
  enigma2-plugin-systemplugins-wirelesslan \
  wireless-tools \
  wpa-supplicant \
"

WLAN_CRYPTO_MODULES = "\
  kernel-module-aes-generic \
  kernel-module-arc4 \
  kernel-module-cryptomgr \
  kernel-module-ecb \
"

WLAN_PCI_MODULES = "\
  kernel-module-ath5k \
"

WLAN_USB_MODULES = "\
  kernel-module-rt73usb \
  kernel-module-zd1211rw \
  rt73-firmware \
  zd1211-firmware \
"

WLAN_USB_MODULES_2_6_18 = "\
  zd1211b \
  wlan-rt73 \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

