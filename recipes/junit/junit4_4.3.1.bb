DESCRIPTION = "JUnit is a testing framework for Java"
LICENSES = "CPL"
AUTHOR = "junit.org"
HOMEPAGE = "http://www.junit.org"

SRC_URI = "http://downloads.sourceforge.net/junit/junit-${PV}-src.jar"

S = "${WORKDIR}"

inherit java-library

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

	# Workaround for jamvm.
	bcp=${STAGING_DATADIR_NATIVE}/classpath/glibj.zip

  javac -source 5.0 -bootclasspath $bcp -sourcepath . -d build `find . -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}
