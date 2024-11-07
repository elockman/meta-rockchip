FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto-dev:"

DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEFAULT_PREFERENCE = "-1"
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:radxa-zero-3 = "radxa-zero-3"

LINUX_VERSION = "6.11"
KERNEL_VERSION_SANITY_SKIP = "1"
PV = "${LINUX_VERSION}+git${SRCPV}"
SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/next/linux-next.git;protocol=https;nobranch=1 \
	file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta \
	"
# this is tag 'v6.11'
SRCREV = "98f7e32f20d28ec452afb208f9cffc08448a2652"
# this is tag 'v6.10'
# SRCREV = "0c3836482481200ead7b416ca80c68a29cfdaabd"
# this is tag 'v6.6'
# SRCREV = "ffc253263a1375a65fa6c9f62a893e9767fbebfa"

inherit kernel
inherit kernel-yocto
require recipes-kernel/linux/linux-yocto.inc
