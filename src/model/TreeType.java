package model;

import javafx.scene.paint.Color;

import java.util.EnumMap;

public enum TreeType {
    PINE(
            new EnumMap<TreeSize, Color>(TreeSize.class) {{
                put(TreeSize.S, Color.rgb(23,203,78));
                put(TreeSize.M, Color.rgb(20,176,78));
                put(TreeSize.L, Color.rgb(28,140,82));
                put(TreeSize.XL, Color.rgb(30,111,79));
                put(TreeSize.XXL, Color.rgb(31,79,81));
            }}
    ),
    LEAF(
            new EnumMap<TreeSize, Color>(TreeSize.class) {{
                put(TreeSize.S, Color.rgb(1,253,13));
                put(TreeSize.M, Color.rgb(1,209,0));
                put(TreeSize.L, Color.rgb(2,164,1));
                put(TreeSize.XL, Color.rgb(0,120,0));
                put(TreeSize.XXL, Color.rgb(1,74,1));
            }}
    );

    private final EnumMap<TreeSize, Color> sizeColorEnumMap;

    TreeType(EnumMap<TreeSize, Color> sizeColorEnumMap) {
        this.sizeColorEnumMap = sizeColorEnumMap;
    }

    public Color getColor(TreeSize size) {
        return sizeColorEnumMap.get(size);
    }
}
