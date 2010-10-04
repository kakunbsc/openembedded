DESCRIPTION = "Additional plugins for Enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PACKAGES_DYNAMIC = "enigma2-plugin-*"

SRCDATE = "20100727"
SRCDATE_vuplus = "20100727"

# if you want the 2.7.0 release, use
#TAG = ";tag=enigma2-plugins_rel27"
#PV = "2.7cvs${SRCDATE}"

# if you want experimental, use:
TAG = ""
PV = "experimental-cvs${SRCDATE}"

# if vuplus
#TAG_vuplus = ";tag=enigma2-plugins_rel28"
#PV_vuplus = "2.8cvs${SRCDATE}"

# if you want vuplus experimental, use:
TAG_vuplus = ""
PV_vuplus = "experimental-cvs${SRCDATE}"
PR_vuplus = "r1"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/enigma2-plugins;module=enigma2-plugins;method=pserver${TAG};date=${SRCDATE}"

SRC_URI_append_vuplus = " \
	   file://enigma2_plugins_mytube_vuplus.patch;patch=1;pnum=1 \
	   file://enigma2_plugins_mytube_entry_vuplus.patch;patch=1;pnum=1 \
           file://dreamboxweb.png \
           file://favicon.ico"

FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts "
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools

S = "${WORKDIR}/enigma2-plugins"

DEPENDS = "python-pyopenssl python-gdata streamripper python-mutagen"
DEPENDS += "enigma2"


def modify_po():
	import os
	try:
		os.system("find ./ -name \"*.po\" > ./po_list")
		os.system("find ./ -name \"*.pot\" >> ./po_list")
		po_list = []
		po_list = open('po_list','r+').readlines()
		for x in po_list:
			changeword1(x)
		changeword1('enigma2-plugins/networkwizard/src/networkwizard.xml ')
		changeword2('enigma2-plugins/webinterface/src/web-data/tpl/default/index.html ')
		os.system('rm po_list')
	except:
		print 'word patch error '
		return

def changeword1(file):
	fn = file[:-1]
	fnn = file[:-1]+'_n'
	cmd = "sed s/Dreambox/STB/g "+fn+" > "+fnn
	os.system(cmd)
	cmd1 = "mv "+fnn+" "+fn
	os.system(cmd1)

def changeword2(file):
	fn = file[:-1]
	fnn = file[:-1]+'_n'
	cmd = "sed s/Dreambox/Vu+/g "+fn+" > "+fnn
	os.system(cmd)
	cmd1 = "mv "+fnn+" "+fn
	os.system(cmd1)

do_unpack_append(){
	modify_po()
}


do_install_append_vuplus() {
	install -m 0644 ${WORKDIR}/dreamboxweb.png ${D}/usr/lib/enigma2/python/Plugins/Extensions/WebInterface/web-data/img/
	install -m 0644 ${WORKDIR}/favicon.ico ${D}/usr/lib/enigma2/python/Plugins/Extensions/WebInterface/web-data/img/
}

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '(.*?/.*?)/.*', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)

	def getControlLines(mydir, d, package):
		import os
		try:
			#ac3lipsync is renamed since 20091121 to audiosync.. but rename in cvs is not possible without lost of revision history..
			#so the foldername is still ac3lipsync
			if package == 'audiosync':
				package = 'ac3lipsync'
			src = open(mydir + package + "/CONTROL/control").read()
		except IOError:
			return
		for line in src.split("\n"):
			if line.startswith('Package: '):
				full_package = line[9:]
			if line.startswith('Depends: '):
				bb.data.setVar('RDEPENDS_' + full_package, ' '.join(line[9:].split(', ')), d)
			if line.startswith('Description: '):
				bb.data.setVar('DESCRIPTION_' + full_package, line[13:], d)
			if line.startswith('Replaces: '):
				bb.data.setVar('RREPLACES_' + full_package, ' '.join(line[10:].split(', ')), d)
			if line.startswith('Conflicts: '):
				bb.data.setVar('RCONFLICTS_' + full_package, ' '.join(line[11:].split(', ')), d)
			if line.startswith('Maintainer: '):
				bb.data.setVar('MAINTAINER_' + full_package, line[12:], d)

	mydir = bb.data.getVar('D', d, 1) + "/../enigma2-plugins/"
	for package in bb.data.getVar('PACKAGES', d, 1).split():
		getControlLines(mydir, d, package.split('-')[-1])
}
