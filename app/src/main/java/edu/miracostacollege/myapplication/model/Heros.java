package edu.miracostacollege.myapplication.model;

import java.util.Objects;

public class Heros {
    private String mName;
    private String mSuperPower;
    private String mOneThing;
    private String mFileName;

    public Heros(String name, String superPower, String oneThing, String fileName) {
        mName = name;
        mSuperPower = superPower;
        mOneThing = oneThing;
        mFileName = fileName;


        name = name.replaceAll(" ", "_");

    }

    public String getName() {
        return mName;
    }

    public String getSuperPower() {
        return mSuperPower;
    }

    public String getOneThing() {
        return mOneThing;
    }

    public String getFileName() {
        return mFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Heros heros = (Heros) o;

        if(!mName.equals(heros.mName)) return false;
        if(!mSuperPower.equals(heros.mSuperPower)) return false;
        if(!mOneThing.equals(heros.mOneThing)) return false;
        return mFileName.equals(heros.mFileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mSuperPower, mOneThing, mFileName);
    }

    @Override
    public String toString() {
        return "Heros{" +
                "mName='" + mName + '\'' +
                ", mSuperPower='" + mSuperPower + '\'' +
                ", mOneThing='" + mOneThing + '\'' +
                ", mFileName='" + mFileName + '\'' +
                '}';
    }
}
