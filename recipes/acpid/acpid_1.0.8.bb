require acpid.inc

SRC_URI_append = " file://event.c.diff;patch=1 \
                   file://fixfd.diff;patch=1 \
                   file://netlink.diff;patch=1"

