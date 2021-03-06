DESCRIPTION = "USB Webcam driver for spca5xx chipset family supporting \
over 100 models of camera"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"

SRC_URI = "http://mxhaard.free.fr/spca50x/Download/spca5xx-${PV}.tar.gz \
           file://Makefile.patch;patch=1"

S = "${WORKDIR}/spca5xx-${PV}"

inherit module

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake 'KERNELDIR=${STAGING_KERNEL_DIR}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
}
