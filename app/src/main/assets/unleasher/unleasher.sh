#!/system/bin/sh

MODDIR=${0%/*}

# Detach/Attach apps from playstore by hinxnz modified for the Youtube Vanced project
# Later modified by MCMotherEffin' for proper Magisk / detach compatibility
# This is an improved version with permanent looping to catch re-attachments of apps since
# newer playstore-app versions do re-attach them (especially youtube app) by scanning for it
# periodically. detachment is done after checking if the entry of the aimed app even is
# available to avoid unnecessary database write access

# How it works
# ------------
# If the file /cache/enable_detach exists the detachment loop starts after booting via magisk's post-fs-data handling
# and does it's thing periodically at a given interval. this is by default once every 60 seconds (this delay can be
# adjusted during runtime by putting a value into the enable_detach file!) which is every 2 mins. unfortunately
# this can't be said exactly because of the influence of sleep  events of the android system, so expect much longer delays
# or even complete stops during that phases! the running loop can be stopped either by deleting the file 'enable_detach'
# in /cache directory (attention apps then stays in a detached statse!) or by putting the file disable_detach into
# /cache dir (recommended!) by doing the latter the disabled services are getting enabled again and detached app(s)
# get attached again after some time or after a reboot which is the common normal state. now there is also a log file
# in /cache directory in which u can follow all the important steps done by the script. some defaults and settings can
# be changed and are explained below

while [ "$(getprop sys.boot_completed)" != 1 ];
do sleep 1;
done

while true
do
chmod 755 /data/adb/modules/ALLIANCE
chmod 755 /data/adb/service.d/unleasher.sh
REB=/data/data/com.shisui.unleasherz/unleasher/a.txt
if [ -f "$REB" ]; then
sleep 0.5
else
rm -r /data/adb/modules/ALLIANCE
sleep 2
rm -rf /data/adb/service.d/unleasher.sh
fi

done