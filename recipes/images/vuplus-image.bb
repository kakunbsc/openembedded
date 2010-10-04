export IMAGE_BASENAME = "vuplus-image"

VUPLUS_COMMON = "\
	task-boot \
	task-vuplus-base \
	task-vuplus-dvbapi \
	task-vuplus-ui \
"



# add bootstrap stuff
DEPENDS = "${VUPLUS_COMMON}"
IMAGE_INSTALL = "${VUPLUS_COMMON}"

# we don't want any locales, at least not in the common way.
IMAGE_LINGUAS = " "


inherit image

vuplus_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # generate /etc/image-version
    IMAGE_VERSION="000"
    IMAGE_DATE="$(date +%Y%m%d%H%M)"
    IMAGE_TYPE="1"
    echo "version=${IMAGE_TYPE}${IMAGE_VERSION}${IMAGE_DATE}" > etc/image-version
#    echo "comment=${DISTRO_NAME}" >> etc/image-version
#    echo "target=9" >> etc/image-version
    echo "creator=DB-Project" >> etc/image-version
    echo "url=http://db-project.com/" >> etc/image-version
#    echo "catalog=http://www.vuplus.com/" >> etc/image-version

    # because we're so used to it
    ln -s opkg usr/bin/ipkg || true
    ln -s opkg-cl usr/bin/ipkg-cl || true

    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "vuplus_rootfs_postprocess; "

export NFO = '${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfo'

generate_nfo() {
    VER=`grep Version: "${IMAGE_ROOTFS}/usr/lib/ipkg/info/enigma2.control" | cut -b 10-26`
    echo "Enigma2: ${VER}" > ${NFO}
    echo "Machine: Vuplus ${MACHINE}" >> ${NFO}
    DATE=`date +%Y-%m-%d' '%H':'%M`
    echo "Date: ${DATE}" >> ${NFO}
#    echo "Issuer: Vuplus" >> ${NFO}
#    echo "Link: ${DISTRO_FEED_URI}" >> ${NFO}
    if [ "${DESC}" != "" ]; then
        echo "Description: ${DESC}" >> ${NFO}
        echo "${DESC}" >> ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.desc
    fi
    MD5SUM=`md5sum ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfi | cut -b 1-32`
    echo "MD5: ${MD5SUM}" >> ${NFO}
}

do_rootfs_append_bm750() {
    generate_nfo
}

do_rootfs_append_vusolo() {
    generate_nfo
}