Castle-Invaders
===============

Multiplattformer Game, created using libGDX


============================
Changelog
============================

Patch 0.05
Patchnotes:
- Bugfix:
 - Mobs will now allways attack the first enemy on lane
 - The "hit" animation will no be properly displayed and the mobs will continue to move while the animation is  
   displayed
- Change:
 - Changed the mainmenu buttons
 - Added selfwritten UI-elements
 - Rewrote complete ingame input mechanics
 - Spawning via drag&drop
- Added:
 - Added a StoreScreen
 - Added store & settings buttons in the mainmenu
 - Added some internal store things (like read storeObjects out of a database)
 - Added burndamage to the lavagolem's fireBalls
 - Added a root effect to the icegolem's grumblingIce


Patch 0.04 30.12.13
Patchnotes:
- Bugfix:
 - Mobs hit instantly (having no delay) after having a deathblow
 - Mob animations
 - Mobs did not always got a target. (hopefully the LAST fix on the combat system)
 

Patch 0.03 29.12.13
Patchnotes:
- Bugfix:
 - Progress wasn't properly saved.
 - Major fixes on the combat system
 - Icetroll movement animation
 - Arrows were fired with no SwingTimer hitting instantly
 - Arrows moved at like 0.0000000001mp/h
 - Change:
 - Orcs did way to much damage in higher levels.
 - Mobs were able to use the Bow, while in combat
 - Significantly decreased loading time between Menu & GameScreen
- Added:
 - ScoreScreen
 - GrumblingIce obtained a root effect.
 - Spark animation to fireballs.
 - Crocos, Skeletons(S/S, Bow), Murlocs
 - Arrows (And other Projectiles)
 - Fire-, Earth-, Ice- dragons as an "Ultimate Attack" with High Mana Cost
 - Also added a Button for that Reason
 - Dragons gain XP through Kills (they need the deathblow to obtain XP)
 - Dragons Strength & Resistances grow with their level
- Notice: Dragons will have upgradeable abilities, which will need a specific DragonLevel to buy/upgrade in the shop

Patch 0.02 02.12.13
Patchnotes:
- Bugfix:
 - Fixed a bug, which made orcs invisible, before first golem spawn.
 
Patch 0.01 Alpha Release 02.12.13
