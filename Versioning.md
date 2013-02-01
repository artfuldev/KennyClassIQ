#Kenny ClassIQ
* Author: Kenshin Himura *(Sudarsan Balaji)*
* License: *GNU GPL v3 and CC-BY-NC-SA Licenses* (see gpl.txt and ccbyncsa.txt)
* Versioning Document Version: 1.4

##Versioning
Starting 1st February, 2013, the versioning convention of __*Kenny ClassIQ*__ has changed. While previously we had a Versioning of 0.0.0.x arbitarily, it has been recently understood that such a system of arbitary versioning will not help in the long run.

Henceforth, I have decided to have my own versioning convention, as there seems to be no standard one, to use with this, and future products which will require versioning.

##Version Description

Any project following this versioning can have its version specified as:

*MaVN.MiVN.MaRN.MiRN (BN)* **or** *MaVN.MiVN.MaRN.MiRN build BN*

***(eg:)*** *2.33.27.96 (5876)* **or** *2.33.27.96* build *5876*,

while stable versions are usually represented as *MaVN.MiVN* without the other version numbers, as stable versions represent builds with *MaRN* and *MiRN* as 0. The 2-digit numbers need not be written in the 2-digit format *(2 as 02)*. Also, trailing numbers having 0 need not be represented at all. Additionally, the *BN* is optional.

***(eg:)*** *21.00.09.00* build *4545* can be represented as *21.0.9*, and *32.0.0.0* can be written as *32* alone.

###Major Version Number (MaVN)
It is a number representing the number of major version changes since its inception. A change in the *Major Version Number* denotes a major change in the program, which incorporate major differences *(new and bug-free functionality)* in the binaries of the compiled code. This may include changes in code architecture or other changes categorized as major changes to the program by me (the author). Also, a change in the MaVN resets the MiVN, MaRN and MiRN to 0, and they need not be mentioned.
###Minor Version Number (MiVN)
It is a 2-digit number representing the number of minor version changes. A change in the *Minor Version Number* denotes a minor change in the program, which incorporate minor differences in the binaries of the compiled code. This may include changes in functionality recently introduced but waiting deployment, major bugfixes, or other changes categorized as minor changes to the program by me (the author). Also, a change in the MaVN resets the MaRN and MiRN to 0, and they need not be specified.
###Major Revision Number (MaRN)
It is a 2-digit number representing the number of major revisions. A change in the *Major Revision Number* denotes a major change in the smaller sections of the program, which incorporate major differences in the functioning or structure of certain sections of the binaries of the compiled code. This may include changes in code for certain functions, minor bugfixes, or other changes categorized as minor revisions to the source code by me (the author). Also, a change in the MaVN resets the MiRN to 0, and it need not be specified.
###Minor Revision Number (MiRN)
It is a 2-digit number representing the number of minor revisions. A change in the *Minor Revision Number* denotes a major change in the smaller sections of the program, which incorporate major differences in the functioning or structure of certain sections of the binaries of the compiled code. This may include changes in code for certain functions, minor bugfixes, or other changes categorized as minor revisions to the source code by me (the author).
###Build Number (BN)
It is a number representing the total number of build changes made to a project since its inception. *For a github repository, this may be equal to or greater than the number of commits, as not all build changes are committed and documented.* It is never reset. Optional.