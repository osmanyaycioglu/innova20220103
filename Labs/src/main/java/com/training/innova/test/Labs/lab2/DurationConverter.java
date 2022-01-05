package com.training.innova.test.Labs.lab2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DurationConverter {

    private static enum EDurationTypes {
        DAY,
        HOUR,
        MINUTE,
        SECOND,
        MILIS;
    }

    public static final String[]                    dayStrs    = {
                                                                   "day",
                                                                   "days",
                                                                   "gun",
                                                                   "gün",
                                                                   "d",
                                                                   "g"
    };
    public static final String[]                    hourStrs   = {
                                                                   "hour",
                                                                   "hours",
                                                                   "saat",
                                                                   "h",
                                                                   "s"
    };

    public static final String[]                    minuteStrs = {
                                                                   "minute",
                                                                   "minutes",
                                                                   "min",
                                                                   "dakika",
                                                                   "dak",
                                                                   "m",
                                                                   "da"
    };

    public static final String[]                    secondStrs = {
                                                                   "second",
                                                                   "seconds",
                                                                   "sec",
                                                                   "secs",
                                                                   "saniye",
                                                                   "san",
                                                                   "se",
                                                                   "sa"
    };

    public static final String[]                    milisStrs  = {
                                                                   "milis"
    };

    public static final Map<String, EDurationTypes> typesMap   = new HashMap<>();

    static {
        for (String stringLoc : DurationConverter.dayStrs) {
            DurationConverter.typesMap.put(stringLoc,
                                           EDurationTypes.DAY);
        }
        for (String stringLoc : DurationConverter.hourStrs) {
            DurationConverter.typesMap.put(stringLoc,
                                           EDurationTypes.HOUR);
        }
        for (String stringLoc : DurationConverter.minuteStrs) {
            DurationConverter.typesMap.put(stringLoc,
                                           EDurationTypes.MINUTE);
        }
        for (String stringLoc : DurationConverter.secondStrs) {
            DurationConverter.typesMap.put(stringLoc,
                                           EDurationTypes.SECOND);
        }
        for (String stringLoc : DurationConverter.milisStrs) {
            DurationConverter.typesMap.put(stringLoc,
                                           EDurationTypes.MILIS);
        }

    }

    private static class DurationParts {

        long   value;
        String durationType;

        @Override
        public String toString() {
            return "[(value=" + this.value + ")(durationType=" + this.durationType + ")]";
        }
    }

    public long convert(final String str) {

        String pureStrLoc = str.replace(" ",
                                        "")
                               .trim();
        String[] splitLoc = pureStrLoc.split(">>");
        String dateStrLoc = null;
        EDurationTypes converTypeLoc = EDurationTypes.MILIS;
        if (splitLoc.length == 1) {
            dateStrLoc = splitLoc[0];
        }
        if (splitLoc.length == 2) {
            dateStrLoc = splitLoc[0];
            converTypeLoc = DurationConverter.typesMap.get(splitLoc[1]);
        } else {
            throw new IllegalArgumentException("Couldn't parse string : "
                                               + str
                                               + " .Please use [durationString] >> [convertType]");
        }
        if (converTypeLoc == null) {
            throw new IllegalArgumentException("Couldn't find convertType string : "
                                               + splitLoc[1]
                                               + " .Please use [durationString] >> [convertType]");

        }
        int iLoc = 0;
        int start = 0;
        int end = 0;
        List<DurationParts> parts = new ArrayList<>();
        for (iLoc = 0; iLoc < dateStrLoc.length(); iLoc++) {
            if (!this.isNumber(dateStrLoc.charAt(iLoc))) {
                continue;
            }
            if (iLoc != 0) {
                iLoc--;
            }
            start = iLoc;
            while (this.isNumber(dateStrLoc.charAt(iLoc))) {
                if (iLoc >= (dateStrLoc.length() - 1)) {
                    iLoc++;
                    break;
                }
                iLoc++;
            }
            end = iLoc;
            String valuetringLoc = dateStrLoc.substring(start,
                                                        end);
            long value = Long.parseLong(valuetringLoc);
            if (iLoc >= dateStrLoc.length()) {
                break;
            }
            start = iLoc;
            while (!this.isNumber(dateStrLoc.charAt(iLoc))) {
                if (iLoc >= (dateStrLoc.length() - 1)) {
                    iLoc++;
                    break;
                }
                iLoc++;
            }
            end = iLoc;
            String typeStringLoc = dateStrLoc.substring(start,
                                                        end);
            DurationParts partsLoc = new DurationParts();
            partsLoc.value = value;
            partsLoc.durationType = typeStringLoc;
            parts.add(partsLoc);
        }
        Duration durLoc = Duration.ZERO;
        for (DurationParts durationPartsLoc : parts) {
            EDurationTypes eDurationTypesLoc = DurationConverter.typesMap.get(durationPartsLoc.durationType);
            if (eDurationTypesLoc == null) {
                throw new IllegalArgumentException("Couldn't parse type : " + durationPartsLoc.durationType);
            }
            switch (eDurationTypesLoc) {
                case DAY:
                    durLoc = durLoc.plusDays(durationPartsLoc.value);
                    break;
                case HOUR:
                    durLoc = durLoc.plusHours(durationPartsLoc.value);
                    break;
                case MINUTE:
                    durLoc = durLoc.plusMinutes(durationPartsLoc.value);
                    break;
                case SECOND:
                    durLoc = durLoc.plusSeconds(durationPartsLoc.value);
                    break;
                case MILIS:
                    durLoc = durLoc.plusMillis(durationPartsLoc.value);
                    break;
                default:
                    break;
            }
        }
        long result = -1;
        switch (converTypeLoc) {
            case DAY:
                result = durLoc.toDays();
                break;
            case HOUR:
                result = durLoc.toHours();
                break;
            case MINUTE:
                result = durLoc.toMinutes();
                break;
            case SECOND:
                result = TimeUnit.SECONDS.convert(durLoc.toMillis(),
                                                  TimeUnit.MILLISECONDS);
                break;
            case MILIS:
                result = durLoc.toMillis();
                break;
            default:
                break;
        }
        return result;
    }

    private boolean isNumber(final char charAtParam) {
        return (charAtParam >= '0') && (charAtParam <= '9');
    }

    public static void main(final String[] args) {
        DurationConverter converterLoc = new DurationConverter();
        long convertLoc = converterLoc.convert("1 day 12 hours >> milis");
        // long convertLoc = converterLoc.convert("1 day 300 hours 12034 minutes 60 seconds 700milis >> saat");
        System.out.println("Sonuc : " + convertLoc);
    }
}
