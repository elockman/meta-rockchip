## Build Host

If possible, start with a fresh install of Ubuntu 22.04.5 LTS (Jammy Jellyfish)  
```
https://releases.ubuntu.com/22.04/
```

To install the required packages on a Debian/Ubuntu run

```
sudo apt update; 
sudo apt install gawk wget git diffstat unzip texinfo gcc build-essential \
    chrpath socat cpio python3 python3-pip python3-pexpect xz-utils \
    debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa \
    libsdl1.2-dev pylint xterm python3-subunit mesa-common-dev zstd liblz4-tool
```

## Configure Yocto/OE

Create a project folder
```
cd ~/
mkdir projects
cd ~/projects
mkdir rock2a
cd ~/projects/rock2a
```

In order to build an image, you need to download some layers.

```
mkdir yocto; cd yocto
git clone git://git.openembedded.org/bitbake -b master
git clone git://git.openembedded.org/openembedded-core -b scarthgap
git clone git://git.yoctoproject.org/meta-arm -b scarthgap
git clone git://git.openembedded.org/meta-openembedded -b scarthgap
git clone https://github.com/elockman/meta-rockchip.git -b scarthgap
git clone git://git.yoctoproject.org/meta-virtualization -b scarthgap
```

Then you need to source the configuration script.

```
source openembedded-core/oe-init-build-env
```

Next, move yocto build config files

```
mv ~/projects/rock2a/yocto/meta-rockchip/conf/local.conf ~/projects/rock2a/yocto/build/conf/
mv ~/projects/rock2a/yocto/meta-rockchip/conf/bblayers.conf ~/projects/rock2a/yocto/build/conf/
```

## Building meta- BSP Layers

Finally, bitbake the project

```
MACHINE=rock-2a bitbake core-image-minimal
```
