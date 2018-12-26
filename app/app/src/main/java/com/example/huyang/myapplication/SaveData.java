package com.example.huyang.myapplication;

import org.litepal.LitePal;

import java.util.List;

public class SaveData<T> implements Runnable{
        private T data;
        private List<T> dataList;
        private String classType;

        public SaveData(T data, String classType) {
            this.data = data;
            this.classType = classType;
        }

        public SaveData(List<T> dataList, String classType) {
            this.dataList = dataList;
            this.classType = classType;
        }

        @Override
        public void run() {
            while (true) {
                if (Global.SAVE_FLAG) {
                    if (classType == "User") {
                        saveCoachData();
                    } else if (classType == "Arcticle") {
                        saveCourseData();
                    }
                    Global.SAVE_FLAG = false;
                    break;
                }
            }
        }

        private void saveCoachData() {
            User user = (User) this.data;
            LitePal.deleteAll("Coach");
                user.save();

        }

        private void saveCourseData() {
            Course course = (Course) this.data;
            LitePal.deleteAll("Course");
                course.save();
        }


}
