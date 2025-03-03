package com.example.video_slicing_tool.Enum;

public enum VideoQuality {
    SD("sntsc"), /* 640 x 480 */
    HD("hd720"), /* 1280 x 720 */
    FULL_HD("hd1080"), /* 1920 x 1080 */
    QUAD_HD("2k"), /* 2048 x 1080 */
    UHD_4K("uhd2160"), /* 3840 x 2160 */
    DCI_4K("4kdci"), /* 4096×2160 */
    EIGHT_K("uhd4320"); /* 8K -> 7680 x 4320*/

    private final String quality;

    VideoQuality(String quality) {
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }
}
