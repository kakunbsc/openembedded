DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
DEPENDS = "jpeg libungif libmad libpng libsigc++-1.2 gettext-native \
	dreambox-dvbincludes freetype libdvbsi++ python swig-native \
	libfribidi libxmlccwrap libdreamdvd gstreamer gst-plugin-dvbmediasink \
	gst-plugins-bad gst-plugins-good gst-plugins-ugly python-wifi"
RDEPENDS = "python-codecs python-core python-lang python-re python-threading \
	python-xml python-fcntl gst-plugin-decodebin gst-plugin-decodebin2 python-stringold \
	python-pickle gst-plugin-app \
	gst-plugin-id3demux gst-plugin-mad gst-plugin-ogg gst-plugin-playbin \
	gst-plugin-typefindfunctions gst-plugin-audioconvert gst-plugin-audioresample \
	gst-plugin-wavparse python-netclient gst-plugin-mpegstream gst-plugin-selector \
	gst-plugin-flac gst-plugin-dvbmediasink gst-plugin-mpegdemux \
	gst-plugin-souphttpsrc gst-plugin-mpegaudioparse gst-plugin-subparse \
	gst-plugin-apetag gst-plugin-icydemux gst-plugin-autodetect \
	glibc-gconv-iso8859-15 ethtool"

GST_RTSP_RDEPENDS = "gst-plugin-udp gst-plugin-rtsp gst-plugin-rtp gst-plugin-rtpmanager"
GST_ALSA_RDEPENDS = "gst-plugin-alsa alsa-conf"
GST_MISC_RDEPENDS = "gst-plugin-matroska gst-plugin-qtdemux gst-plugin-vorbis gst-plugin-audioparsersbad"
GST_DVD_RDEPENDS = "gst-plugin-cdxaparse gst-plugin-cdio gst-plugin-vcdsrc"
GST_BASE_RDEPENDS = "${GST_ALSA_RDEPENDS} ${GST_MISC_RDEPENDS} ${GST_RTSP_RDEPENDS}"

RDEPENDS_append_dm7025 = " ${GST_ALSA_RDEPENDS} gst-plugin-ivorbisdec"
RDEPENDS_append_dm800 = " ${GST_BASE_RDEPENDS} gst-plugin-ivorbisdec"
RDEPENDS_append_dm8000 = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_dm500hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_dm800se = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_bm750 = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_vuplus = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"

# 'forward depends' - no two providers can have the same PACKAGES_DYNAMIC, however both
# enigma2 and enigma2-plugins produce enigma2-plugin-*.
#DEPENDS += "enigma2-plugins"
#PACKAGES_DYNAMIC = "enigma2-plugin-*"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-frontprocessorupdate = "keeps your frontprocessor up to date."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-skinselector = "shows a menu with selectable skins."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-extensions-dvdplayer = "libdreamdvd0"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "twisted-web"
RCONFLICTS_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
RREPLACES_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
DESCRIPTION_append_enigma2-plugin-systemplugins-crashlogautosubmit = "automatically send crashlogs to Dream Multimedia"
RDEPENDS_enigma2-plugin-systemplugins-crashlogautosubmit = "twisted-mail twisted-names python-compression python-mime python-email"
DESCRIPTION_append_enigma2-plugin-systemplugins-cleanupwizard = "informs you on low internal memory on system startup."
DESCRIPTION_append_enigma2-plugin-extenstions-modem = "opens a menu to connect to internet via builtin modem."
RDEPENDS_enigma2-plugin-extensions-modem = "dreambox-modem-ppp-scripts ppp"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python-wifi"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"

PN = "enigma2"
PR = "r0"

SRCDATE = "20100728"
SRCDATE_vuplus = "20101003"
#SRCDATE is NOT used by git to checkout a specific revision
#but we need it to build a ipk package version
#when you like to checkout a specific revision of e2 you need
#have to specify a commit id or a tag name in SRCREV

# if you want upcoming release, use:
####################################################
#BRANCH = "master"
#PV = "2.8git${SRCDATE}"
#SRCREV = ""
####################################################

# if you want experimental use
####################################################
BRANCH = "experimental"
PV = "experimental-git${SRCDATE}"
SRCREV = ""
####################################################

# if you want a 2.7-based release, use
####################################################
#BRANCH="2.7"
#PV = "2.7git${SRCDATE}"
# if you want 2.7.0 use
#SRCREV = "d5a16c6e9d0ee1cc2dc0d65b4321842dea4b0891"
####################################################

# if you want a vuplus release, use
####################################################
#BRANCH_vuplus = "vuplus"
#PV_vuplus = "2.8git${SRCDATE}"
#SRCREV_vuplus = "4186f8c308d9450353520a88eb5a5ee3940281d3"
####################################################

#if you want a vuplus experimental, use
####################################################
#BRANCH_vuplus = "vuplus_experimental"
BRANCH_vuplus = "master"
PV_vuplus = "experimental-git${SRCDATE}"
SRCREV_vuplus = ""
####################################################

SRC_URI = "git://git.opendreambox.org/git/enigma2.git;protocol=git;branch=${BRANCH};tag=${SRCREV} \
	file://new-hotplug.patch;patch=1;pnum=1 \
	file://enigma2.sh"

SRC_URI_bm750 = "git://github.com/kakunbsc/enigma2.git;protocol=git;branch=${BRANCH};tag=${SRCREV} \
	   file://enigma2_vuplus_duo.patch;patch=1;pnum=1 \
#           file://enigma2_vuplus_skin.patch;patch=1;pnum=1 \
           file://enigma2_vuplus_mediaplayer.patch;patch=1;pnum=1 \
#           file://MyriadPro-Regular.otf \
#          file://MyriadPro-Semibold.otf \
#           file://MyriadPro-SemiboldIt.otf \
#           file://750S \
#           file://Vu_HD \
#           file://number_key \
           file://enigma2.sh"

SRC_URI_vusolo = "git://github.com/kakunbsc/enigma2.git;protocol=git;branch=${BRANCH};tag=${SRCREV} \
#           file://enigma2_vuplus_skin.patch;patch=1;pnum=1 \
           file://enigma2_vuplus_mediaplayer.patch;patch=1;pnum=1 \
#           file://MyriadPro-Regular.otf \
#           file://MyriadPro-Semibold.otf \
#           file://MyriadPro-SemiboldIt.otf \
#           file://750S \
#           file://Vu_HD \
#           file://number_key \
           file://enigma2.sh"

def change_po():
        import os
        try:
                os.system("find ./ -name \"*.po\" > ./po_list")
                os.system("find ./ -name \"*.pot\" >> ./po_list")
                po_list = []
                po_list = open('po_list','r+').readlines()
                for x in po_list:
                        changeword(x)
                os.system('rm po_list')
        except:
                print 'word patch error '
                return

def changeword(file):
        fn = file[:-1]
        fnn = file[:-1]+'_n'
        cmd = "sed s/Dreambox/STB/g "+fn+" > "+fnn
        os.system(cmd)
        cmd1 = "mv "+fnn+" "+fn
        os.system(cmd1)

do_unpack_append(){
        change_po()
}

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/fonts"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native --with-libsdl=no"

#do_compile_prepend_vuplus() {
#        install -m 0755 ${WORKDIR}/MyriadPro-Regular.otf ${S}/data/fonts/
#        install -m 0755 ${WORKDIR}/MyriadPro-Semibold.otf ${S}/data/fonts/
#        install -m 0755 ${WORKDIR}/MyriadPro-SemiboldIt.otf ${S}/data/fonts/
#        install -m 0755 ${WORKDIR}/750S/*.png ${S}/data/750S/
#        install -m 0755 ${WORKDIR}/750S/buttons/*.png ${S}/data/750S/buttons/
#        install -m 0755 ${WORKDIR}/750S/countries/*.png ${S}/data/750S/countries/
#        install -m 0755 ${WORKDIR}/750S/icons/*.png ${S}/data/750S/icons/
#        install -m 0755 ${WORKDIR}/750S/menu/*.png ${S}/data/750S/menu/
#        install -m 0755 ${WORKDIR}/750S/spinner/*.png ${S}/data/skin_default/spinner/
#        install -m 0755 ${WORKDIR}/Vu_HD/*.png ${S}/data/Vu_HD/
#        install -m 0755 ${WORKDIR}/Vu_HD/buttons/*.png ${S}/data/Vu_HD/buttons/
#        install -m 0755 ${WORKDIR}/Vu_HD/countries/*.png ${S}/data/Vu_HD/countries/
#        install -m 0755 ${WORKDIR}/Vu_HD/icons/*.png ${S}/data/Vu_HD/icons/
#        install -m 0755 ${WORKDIR}/Vu_HD/menu/*.png ${S}/data/Vu_HD/menu/
#        install -m 0755 ${WORKDIR}/number_key/*.png ${S}/data/skin_default/buttons/
#}

do_install_append() {
	install -m 0755 ${WORKDIR}/enigma2.sh ${D}/usr/bin/
}

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '(.*?/.*?)/.*', 'enigma2-plugin-%s', '%s ', recursive=True, match_path=True, prepend=True)
}

do_stage() {
	install -d ${STAGING_INCDIR}/enigma2
	install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/enigma2
	for dir in actions base components driver dvb dvb/lowlevel dvb_ci gdi gui mmi nav python service; do
		install -d ${STAGING_INCDIR}/enigma2/lib/$dir;
		install -m 0644 ${S}/lib/$dir/*.h ${STAGING_INCDIR}/enigma2/lib/$dir;
	done
}
