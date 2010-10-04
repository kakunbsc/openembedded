SRC_URI = "file://80-squashfs.sh"
PR = "r1"
DESCRIPTION = "An initramfs module for mount squashfs."
RDEPENDS = "initramfs-uniboot"

do_install() {
    install -d ${D}/initrd.d
    install -m 0755 ${WORKDIR}/80-squashfs.sh ${D}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /initrd.d/* "
