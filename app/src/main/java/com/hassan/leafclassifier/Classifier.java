package com.hassan.leafclassifier;

import android.graphics.Bitmap;
import android.graphics.RectF;

import java.util.List;
import java.util.Objects;


/**
 * Generic interface for interacting with different recognition engines.
 */
public interface Classifier {
    /**
     * An immutable result returned by a Classifier describing what was recognized.
     */
    class Recognition {
        /**
         * A unique identifier for what has been recognized. Specific to the class, not the instance of
         * the object.
         */
        private final String id;

        /**
         * Display name for the recognition.
         */
        private final String title;

        /**
         * A sortable score for how good the recognition is relative to others. Higher should be better.
         */
        private final Float confidence;


        private String thaiName;

        /**
         * Optional location within the source image for the location of the recognized object.
         */
        private RectF location;

        public Recognition(
                final String id, final String title, final Float confidence, final RectF location) {
            this.id = id;
            this.title = title;
            this.confidence = confidence;
            this.location = location;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public Float getConfidence() {
            return confidence;
        }

        public RectF getLocation() {
            return new RectF(location);
        }

        public void setLocation(RectF location) {
            this.location = location;
        }


        @Override
        public String toString() {
            String resultString = "";
            if (id != null) {
                if (Objects.equals(id, "0"))
                    thaiName = "ทองอุไร";
                else if (Objects.equals(id, "1"))
                    thaiName = "ติ้วขน";
                else if (Objects.equals(id, "2"))
                    thaiName = "กันเกรา";
                else if (Objects.equals(id, "3"))
                    thaiName = "สารภี";
                else if (Objects.equals(id, "4"))
                    thaiName = "ลำดวน";
                else if (Objects.equals(id, "5"))
                    thaiName = "เชอรี่สเปน";
                else if (Objects.equals(id, "6"))
                    thaiName = "เข็ม";
                else if (Objects.equals(id, "7"))
                    thaiName = "พิลังกาสา";
                else if (Objects.equals(id, "8"))
                    thaiName = "การเวก";
                else if (Objects.equals(id, "9"))
                    thaiName = "ตะขบ";
                //resultString += "[" + id + "] ";
                resultString += "ชื่อไทย : " + thaiName + "\n";
            }

            if (title != null) {
                resultString += "ชื่อวิทยาศาสตร์ : " + title + "\n";
            }

            if (confidence != null) {
                resultString += "ค่าความเชื่อมั่น : " + String.format("(%.1f%%) ", confidence * 100.0f) + "\n";
            }

            if (location != null) {
                //resultString += location + " ";
            }

            return resultString.trim();
        }
    }

    List<Recognition> recognizeImage(Bitmap bitmap);

    void enableStatLogging(final boolean debug);

    String getStatString();

    void close();
}

