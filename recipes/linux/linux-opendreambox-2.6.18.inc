require linux-opendreambox.inc

SRCREV = "97b869e710d741d3eda4f7c915d6190b4054d290"
PR_INC="r5"

RREPLACES_kernel = "kernel-2.6.18-7.1-${MACHINE}"
RCONFLICTS_kernel = "kernel-2.6.18-7.1-${MACHINE}"
RREPLACES_kernel-image = "kernel-image-2.6.18-7.1-${MACHINE}"
RCONFLICTS_kernel-image = "kernel-image-2.6.18-7.1-${MACHINE}"

SRC_URI += " http://trappist.elis.ugent.be/~mronsse/cdfs/download/cdfs-2.6.18.tar.bz2 \
	file://stblinux-2.6.18-cdfs.patch \
	file://linux-2.6.18-fix-mips-crosscompile.patch;patch=1 \
	file://linux-2.6.18-fix-proc-cputype.patch;patch=1 \
	file://linux-2.6.18-hdd-detection-fix.patch;patch=1"

do_configure_prepend() {
	if [ -d ${WORKDIR}/cdfs-${PV} ]; then
		mv ${WORKDIR}/cdfs-${PV} ${S}/fs/cdfs
		cd ${S} & patch -p1 < ${WORKDIR}/stblinux-2.6.18-cdfs.patch
	fi;
}
