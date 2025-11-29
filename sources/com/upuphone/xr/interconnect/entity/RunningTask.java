package com.upuphone.xr.interconnect.entity;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.List;

public class RunningTask implements Parcelable {
    public static final Parcelable.Creator<RunningTask> CREATOR = new Parcelable.Creator<RunningTask>() {
        public RunningTask createFromParcel(Parcel parcel) {
            RunningTask runningTask = new RunningTask();
            runningTask.readFromParcel(parcel);
            return runningTask;
        }

        public RunningTask[] newArray(int i) {
            return new RunningTask[i];
        }
    };
    public List<String> actions;
    public String executorName;
    public int id = 0;
    public List<ResourceDescription> occupiedResources;
    public Bundle param;

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    public int describeContents() {
        return describeContents(this.param) | describeContents(this.occupiedResources);
    }

    public final void readFromParcel(Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        if (readInt >= 4) {
            try {
                if (parcel.dataPosition() - dataPosition < readInt) {
                    this.id = parcel.readInt();
                    if (parcel.dataPosition() - dataPosition < readInt) {
                        this.executorName = parcel.readString();
                        if (parcel.dataPosition() - dataPosition < readInt) {
                            this.occupiedResources = parcel.createTypedArrayList(ResourceDescription.CREATOR);
                            if (parcel.dataPosition() - dataPosition < readInt) {
                                this.param = (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR);
                                if (parcel.dataPosition() - dataPosition < readInt) {
                                    this.actions = parcel.createStringArrayList();
                                    if (dataPosition <= Integer.MAX_VALUE - readInt) {
                                        parcel.setDataPosition(dataPosition + readInt);
                                        return;
                                    }
                                    throw new BadParcelableException("Overflow in the size of parcelable");
                                } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                                    throw new BadParcelableException("Overflow in the size of parcelable");
                                }
                            } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                                throw new BadParcelableException("Overflow in the size of parcelable");
                            }
                        } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                            throw new BadParcelableException("Overflow in the size of parcelable");
                        }
                    } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                        throw new BadParcelableException("Overflow in the size of parcelable");
                    }
                } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                    throw new BadParcelableException("Overflow in the size of parcelable");
                }
                parcel.setDataPosition(dataPosition + readInt);
            } catch (Throwable th) {
                if (dataPosition > Integer.MAX_VALUE - readInt) {
                    throw new BadParcelableException("Overflow in the size of parcelable");
                }
                parcel.setDataPosition(dataPosition + readInt);
                throw th;
            }
        } else {
            throw new BadParcelableException("Parcelable too small");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        parcel.writeInt(this.id);
        parcel.writeString(this.executorName);
        parcel.writeTypedList(this.occupiedResources);
        _Parcel.writeTypedObject(parcel, this.param, i);
        parcel.writeStringList(this.actions);
        int dataPosition2 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition2 - dataPosition);
        parcel.setDataPosition(dataPosition2);
    }

    private int describeContents(Object obj) {
        int i = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Collection) {
            for (Object describeContents : (Collection) obj) {
                i |= describeContents(describeContents);
            }
            return i;
        } else if (obj instanceof Parcelable) {
            return ((Parcelable) obj).describeContents();
        } else {
            return 0;
        }
    }
}
