require gdb-cross.inc
LICENSE = "GPLv3"

SRC_URI += "file://gcc-4.3-build-error.patch;patch=1;pnum=0 \
            file://gdb-6.8-fix-compile-karmic.patch;patch=1"

inherit cross

PR = "r3"
