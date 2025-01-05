# RE3 - Mercenaries Item Editor byMystic

Edit the starting items for characters in Mercenaries mode in Resident Evil 3: Nemesis (1999) [PC] SourceNext version.

## 📖 Introduction

Have you ever wished *Carlos, Mikhail,* and *Nicholai* had access to different weapons/ammo or health items in the **original** Resident Evil 3's Mercenaries mode? Well, with this tool you can make it happen. Simply load your game's .exe file to modify the inventory of each character.

>*It's important to note that this tool is only compatible with the SourceNext PC version of the game. It has been specifically tested with the SourceNext Official 1.1.0 patch, but it may also work with the original release. For the easiest experience, I recommend applying the Resident Evil 3 Classic [REbirth patch](https://classicrebirth.com/index.php/downloads/resident-evil-3-classic-rebirth/) to your SourceNext version.*

## ⚙️ Installation

The first thing you need to do is download the tool [here](https://github.com/jmncamilo/re3-merc-item-editor/releases/download/v1.0.1/MercenariesItemEditor.zip).

Tool is a .JAR executable, that means you need to have Java installed on your computer. If you're not familiar with Java and don't have it installed, simply [click here](https://www.oracle.com/java/technologies/javase/jdk23-archive-downloads.html).

The link will take you to Oracle's website to download Java. Look for the *"Java SE Development Kit 23.0.1"*. Why this one? Because it is the specific version I used to build the project, so it should work perfectly!

Next, find your operating system in the list under *"Product / File Description"*. Click the link next to it to start the download. Once the file is downloaded, just run it like you would any other program. It should install without any issues, but if you run into any trouble, let me know and I'll be happy to help.

And that's it! You've successfully installed Java on your computer. Now you can run the .JAR file without any problems.

## 🚀 Quickstart

<div align="center">
  <img src="\assets\img01.png" alt="UX1" />
</div>

This tool is very easy to use; you won't have any problems. The first thing you need to do is open your game's .exe file, the game's executable. As mentioned, it must be the SourceNext version, which by default is named **BIOHAZARD(R) 3 PC**.

<div align="center">
  <img src="\assets\img02.png" alt="UX2" />
</div>

On the next screen, you will need to perform the following steps:

**1.** Select the character you want to edit.

**2.** Choose the slot you want to modify. When I say slot, I mean the place in the hand inventory you want to modify. For example, Carlos' first slot by default in the game is an Assault Rifle. If you select slot 1, you will be modifying that item.

**3.** In the *Item* section you can select the item you want to put from the dropdown list. You can choose between weapons, ammo or health items.

**4.** In the *Qty* section you can set the quantity (as an integer) you want of that item. For example, if you enter the number 7 here and you have chosen Rocket Launcher as the item, then your weapon will have 5 rockets of ammunition.

**5.** In *Color* section you can choose the color you want to display for that quantity you have set. For example, when you have freeze grenades, the game by default shows the ammunition number in blue. It's the same here; the color you choose (you can choose No display) will be applied to the value shown for the quantity you have set. The "Inf." options refer to *infinite value*.

**6.** Click save button and that's it. You have modified your game!

>*It is highly recommended to always select a weapon for each character's first inventory slot, as placing healing or ammunition items there may result in a game crash.*
>
>>*The item icons and names shown on the character selection screen
remain unchanged. This tool only modifies the actual in-game items.*
>>
>>Some items may not render correctly in-game. For example, some weapons might appear invisible in the player's hand, but they still fire bullets. I suppose Capcom developers limited certain objects to the Mercenaries game mode to save memory. You may encounter bugs with other items. Please test thoroughly and share your findings with the community.

## 🔐 License

This software is distributed under the terms of the GNU Affero General Public License v3.0 (AGPLv3). A copy of this license can be found in the [LICENSE](LICENSE) file. The AGPLv3 guarantees your freedoms to use, study, share, and modify this software. However, it also requires that any derivative works based on this software be distributed under the same license terms.

[![License](https://img.shields.io/badge/AGPLv3-AGPLv3?style=social&logo=gnu&logoColor=%23A42E2B&logoSize=20&label=License)](https://www.gnu.org/licenses/gpl-3.0.en.html)

