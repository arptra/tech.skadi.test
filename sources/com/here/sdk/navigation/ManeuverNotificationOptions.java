package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.UnitSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class ManeuverNotificationOptions {
    @NonNull
    public DirectionInformationUsageOption directionInformationUsageForActionNotificationOption;
    public boolean enableDestinationReachedNotification;
    public boolean enableDoubleNotification;
    public boolean enableHighwayExit;
    public boolean enablePhoneme;
    public boolean enableRoundaboutNotification;
    @NonNull
    public List<NaturalGuidanceType> includedNaturalGuidanceTypes;
    @NonNull
    public List<ManeuverNotificationType> includedNotificationTypes;
    @NonNull
    public LanguageCode language;
    @NonNull
    public NotificationFormatOption notificationFormatOption;
    @NonNull
    public LocalizedTextUsageOption roadNumberUsageOption;
    @NonNull
    public LocalizedTextUsageOption signpostDirectionUsageOption;
    @NonNull
    public LocalizedTextUsageOption streetNameUsageOption;
    @NonNull
    public UnitSystem unitSystem;

    public ManeuverNotificationOptions() {
        this.language = LanguageCode.EN_US;
        this.unitSystem = UnitSystem.METRIC;
        this.includedNotificationTypes = new ArrayList(Arrays.asList(new ManeuverNotificationType[]{ManeuverNotificationType.RANGE, ManeuverNotificationType.REMINDER, ManeuverNotificationType.DISTANCE, ManeuverNotificationType.ACTION}));
        this.enableRoundaboutNotification = true;
        this.enableDestinationReachedNotification = true;
        this.enableDoubleNotification = true;
        this.enablePhoneme = false;
        this.notificationFormatOption = NotificationFormatOption.PLAIN;
        LocalizedTextUsageOption localizedTextUsageOption = LocalizedTextUsageOption.ALWAYS;
        this.streetNameUsageOption = localizedTextUsageOption;
        this.roadNumberUsageOption = localizedTextUsageOption;
        this.signpostDirectionUsageOption = localizedTextUsageOption;
        this.enableHighwayExit = true;
        this.includedNaturalGuidanceTypes = new ArrayList();
        this.directionInformationUsageForActionNotificationOption = DirectionInformationUsageOption.NONE;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ManeuverNotificationOptions)) {
            return false;
        }
        ManeuverNotificationOptions maneuverNotificationOptions = (ManeuverNotificationOptions) obj;
        return Objects.equals(this.language, maneuverNotificationOptions.language) && Objects.equals(this.unitSystem, maneuverNotificationOptions.unitSystem) && Objects.equals(this.includedNotificationTypes, maneuverNotificationOptions.includedNotificationTypes) && this.enableRoundaboutNotification == maneuverNotificationOptions.enableRoundaboutNotification && this.enableDestinationReachedNotification == maneuverNotificationOptions.enableDestinationReachedNotification && this.enableDoubleNotification == maneuverNotificationOptions.enableDoubleNotification && this.enablePhoneme == maneuverNotificationOptions.enablePhoneme && Objects.equals(this.notificationFormatOption, maneuverNotificationOptions.notificationFormatOption) && Objects.equals(this.streetNameUsageOption, maneuverNotificationOptions.streetNameUsageOption) && Objects.equals(this.roadNumberUsageOption, maneuverNotificationOptions.roadNumberUsageOption) && Objects.equals(this.signpostDirectionUsageOption, maneuverNotificationOptions.signpostDirectionUsageOption) && this.enableHighwayExit == maneuverNotificationOptions.enableHighwayExit && Objects.equals(this.includedNaturalGuidanceTypes, maneuverNotificationOptions.includedNaturalGuidanceTypes) && Objects.equals(this.directionInformationUsageForActionNotificationOption, maneuverNotificationOptions.directionInformationUsageForActionNotificationOption);
    }

    public int hashCode() {
        LanguageCode languageCode = this.language;
        int i = 0;
        int hashCode = (217 + (languageCode != null ? languageCode.hashCode() : 0)) * 31;
        UnitSystem unitSystem2 = this.unitSystem;
        int hashCode2 = (hashCode + (unitSystem2 != null ? unitSystem2.hashCode() : 0)) * 31;
        List<ManeuverNotificationType> list = this.includedNotificationTypes;
        int i2 = 97;
        int hashCode3 = (((((((((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + (this.enableRoundaboutNotification ? 79 : 97)) * 31) + (this.enableDestinationReachedNotification ? 79 : 97)) * 31) + (this.enableDoubleNotification ? 79 : 97)) * 31) + (this.enablePhoneme ? 79 : 97)) * 31;
        NotificationFormatOption notificationFormatOption2 = this.notificationFormatOption;
        int hashCode4 = (hashCode3 + (notificationFormatOption2 != null ? notificationFormatOption2.hashCode() : 0)) * 31;
        LocalizedTextUsageOption localizedTextUsageOption = this.streetNameUsageOption;
        int hashCode5 = (hashCode4 + (localizedTextUsageOption != null ? localizedTextUsageOption.hashCode() : 0)) * 31;
        LocalizedTextUsageOption localizedTextUsageOption2 = this.roadNumberUsageOption;
        int hashCode6 = (hashCode5 + (localizedTextUsageOption2 != null ? localizedTextUsageOption2.hashCode() : 0)) * 31;
        LocalizedTextUsageOption localizedTextUsageOption3 = this.signpostDirectionUsageOption;
        int hashCode7 = (hashCode6 + (localizedTextUsageOption3 != null ? localizedTextUsageOption3.hashCode() : 0)) * 31;
        if (this.enableHighwayExit) {
            i2 = 79;
        }
        int i3 = (hashCode7 + i2) * 31;
        List<NaturalGuidanceType> list2 = this.includedNaturalGuidanceTypes;
        int hashCode8 = (i3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        DirectionInformationUsageOption directionInformationUsageOption = this.directionInformationUsageForActionNotificationOption;
        if (directionInformationUsageOption != null) {
            i = directionInformationUsageOption.hashCode();
        }
        return hashCode8 + i;
    }

    public ManeuverNotificationOptions(@NonNull LanguageCode languageCode, @NonNull UnitSystem unitSystem2) {
        this.language = languageCode;
        this.unitSystem = unitSystem2;
        this.includedNotificationTypes = new ArrayList(Arrays.asList(new ManeuverNotificationType[]{ManeuverNotificationType.RANGE, ManeuverNotificationType.REMINDER, ManeuverNotificationType.DISTANCE, ManeuverNotificationType.ACTION}));
        this.enableRoundaboutNotification = true;
        this.enableDestinationReachedNotification = true;
        this.enableDoubleNotification = true;
        this.enablePhoneme = false;
        this.notificationFormatOption = NotificationFormatOption.PLAIN;
        LocalizedTextUsageOption localizedTextUsageOption = LocalizedTextUsageOption.ALWAYS;
        this.streetNameUsageOption = localizedTextUsageOption;
        this.roadNumberUsageOption = localizedTextUsageOption;
        this.signpostDirectionUsageOption = localizedTextUsageOption;
        this.enableHighwayExit = true;
        this.includedNaturalGuidanceTypes = new ArrayList();
        this.directionInformationUsageForActionNotificationOption = DirectionInformationUsageOption.NONE;
    }

    public ManeuverNotificationOptions(@NonNull LanguageCode languageCode, @NonNull UnitSystem unitSystem2, @NonNull List<ManeuverNotificationType> list, boolean z, boolean z2, boolean z3, boolean z4, @NonNull LocalizedTextUsageOption localizedTextUsageOption, @NonNull LocalizedTextUsageOption localizedTextUsageOption2, @NonNull LocalizedTextUsageOption localizedTextUsageOption3, boolean z5) {
        this.language = languageCode;
        this.unitSystem = unitSystem2;
        this.includedNotificationTypes = list;
        this.enableRoundaboutNotification = z;
        this.enableDestinationReachedNotification = z2;
        this.enableDoubleNotification = z3;
        this.enablePhoneme = z4;
        this.streetNameUsageOption = localizedTextUsageOption;
        this.roadNumberUsageOption = localizedTextUsageOption2;
        this.signpostDirectionUsageOption = localizedTextUsageOption3;
        this.enableHighwayExit = z5;
        this.notificationFormatOption = NotificationFormatOption.PLAIN;
        this.includedNaturalGuidanceTypes = new ArrayList();
        this.directionInformationUsageForActionNotificationOption = DirectionInformationUsageOption.NONE;
    }

    public ManeuverNotificationOptions(@NonNull LanguageCode languageCode, @NonNull UnitSystem unitSystem2, @NonNull List<ManeuverNotificationType> list, boolean z, boolean z2, boolean z3, boolean z4, @NonNull NotificationFormatOption notificationFormatOption2, @NonNull LocalizedTextUsageOption localizedTextUsageOption, @NonNull LocalizedTextUsageOption localizedTextUsageOption2, @NonNull LocalizedTextUsageOption localizedTextUsageOption3, boolean z5) {
        this.language = languageCode;
        this.unitSystem = unitSystem2;
        this.includedNotificationTypes = list;
        this.enableRoundaboutNotification = z;
        this.enableDestinationReachedNotification = z2;
        this.enableDoubleNotification = z3;
        this.enablePhoneme = z4;
        this.notificationFormatOption = notificationFormatOption2;
        this.streetNameUsageOption = localizedTextUsageOption;
        this.roadNumberUsageOption = localizedTextUsageOption2;
        this.signpostDirectionUsageOption = localizedTextUsageOption3;
        this.enableHighwayExit = z5;
        this.includedNaturalGuidanceTypes = new ArrayList();
        this.directionInformationUsageForActionNotificationOption = DirectionInformationUsageOption.NONE;
    }
}
