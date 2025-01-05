package models;

import java.util.LinkedHashMap;

public class HashValues {

    private final LinkedHashMap<String, Byte> itemsId;
    private final LinkedHashMap<String, Byte> colorDisp;

    public HashValues() {
        // Key and values for items
        itemsId = new LinkedHashMap<>();
        itemsId.put("Combat Knife", (byte) 0x01); // Guns start here
        itemsId.put("Sigpro SP 2009", (byte) 0x02);
        itemsId.put("M92F Custom", (byte) 0x03);
        itemsId.put("Benelli M3S", (byte) 0x04);
        itemsId.put("S&W Magnum", (byte) 0x05);
        itemsId.put("Hk-p (Burst)", (byte) 0x06);
        itemsId.put("Hk-p (Flame)", (byte) 0x07);
        itemsId.put("Hk-p (Acid)", (byte) 0x08);
        itemsId.put("Hk-p (Freeze)", (byte) 0x09);
        itemsId.put("Rocket Launcher", (byte) 0x0A);
        itemsId.put("Gatling Gun", (byte) 0x0B);
        itemsId.put("Mine Thrower", (byte) 0x0C);
        itemsId.put("STI Eagle 6.0", (byte) 0x0D);
        itemsId.put("M4A1 (Manual)", (byte) 0x0E);
        itemsId.put("M4A1 (Auto)", (byte) 0x0F);
        itemsId.put("Shotgun M37", (byte) 0x10);
        itemsId.put("Sigpro E", (byte) 0x11);
        itemsId.put("M92F Custom E", (byte) 0x12);
        itemsId.put("Benelli M3S E", (byte) 0x13);
        itemsId.put("Mine Thrower E", (byte) 0x14);
        itemsId.put("Hand Gun Bullets", (byte) 0x15); // Ammo starts here
        itemsId.put("Magnum Bullets", (byte) 0x16);
        itemsId.put("Shotgun Shells", (byte) 0x17);
        itemsId.put("Grenade Rounds", (byte) 0x18);
        itemsId.put("Flame Rounds", (byte) 0x19);
        itemsId.put("Acid Rounds", (byte) 0x1A);
        itemsId.put("Freeze Rounds", (byte) 0x1B);
        itemsId.put("Mine T. Rounds", (byte) 0x1C);
        itemsId.put("AR Bullets", (byte) 0x1D);
        itemsId.put("HG Bullets E", (byte) 0x1E);
        itemsId.put("S. Shells E", (byte) 0x1F);
        itemsId.put("Eagle Parts A", (byte) 0x59);
        itemsId.put("Eagle Parts B", (byte) 0x5A);
        itemsId.put("M37 Parts A", (byte) 0x5B);
        itemsId.put("M37 Parts B", (byte) 0x5C);
        itemsId.put("Infinite Bullets", (byte) 0x6E);
        itemsId.put("First Aid Spray", (byte) 0x20);  // Recovery items start here
        itemsId.put("Green Herb", (byte) 0x21);
        itemsId.put("Blue Herb", (byte) 0x22);
        itemsId.put("Red Herb", (byte) 0x23);
        itemsId.put("2x Green Herb", (byte) 0x24);
        itemsId.put("G. + Blue Herb", (byte) 0x25);
        itemsId.put("G. + Red Herb", (byte) 0x26);
        itemsId.put("3x Green Herb", (byte) 0x27);
        itemsId.put("2x G. + B. Herb", (byte) 0x28);
        itemsId.put("G+R+B Herb", (byte) 0x29);
        itemsId.put("First Aid Box", (byte) 0x2A);

        // Key and values for color display
        colorDisp = new LinkedHashMap<>();
        colorDisp.put("No Display", (byte) 0x00); // No display color
        colorDisp.put("Green", (byte) 0x01); // Starting green color
        colorDisp.put("% Green", (byte) 0x02);
        colorDisp.put("Inf. Green", (byte) 0x03);
        colorDisp.put("Red", (byte) 0x05); // Starting red color
        colorDisp.put("% Red", (byte) 0x06);
        colorDisp.put("Inf. Red", (byte) 0x07);
        colorDisp.put("Yellow", (byte) 0x09); // Starting yellow color
        colorDisp.put("% Yellow", (byte) 0x0A);
        colorDisp.put("Inf. Yellow", (byte) 0x0B);
        colorDisp.put("Blue", (byte) 0x0D); // Starting blue color
        colorDisp.put("% Blue", (byte) 0x0E);
        colorDisp.put("Inf. Blue", (byte) 0x0F);
    }


    // Getter for itemsId
    public LinkedHashMap<String, Byte> getItemsId() {
        return itemsId; // Returns the object LinkedHashMap
    }

    // Getter for colorDisp
    public LinkedHashMap<String, Byte> getColorDisp() {
        return colorDisp; // Returns the object LinkedHashMap
    }



}
