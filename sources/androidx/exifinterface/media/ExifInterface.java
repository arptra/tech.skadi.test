package androidx.exifinterface.media;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterfaceUtils;
import com.google.mlkit.common.MlKitException;
import com.meizu.common.widget.MzContactsContract;
import com.ucar.databus.proto.UCarProto;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.DfuBaseService;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
    static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{2, 7, 4, 5});
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final Pattern GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, 49};
    private static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, RingSecurityPair.OPCODE_RING_PAIR};
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    static final int IMAGE_TYPE_ARW = 1;
    static final int IMAGE_TYPE_CR2 = 2;
    static final int IMAGE_TYPE_DNG = 3;
    static final int IMAGE_TYPE_HEIF = 12;
    static final int IMAGE_TYPE_JPEG = 4;
    static final int IMAGE_TYPE_NEF = 5;
    static final int IMAGE_TYPE_NRW = 6;
    static final int IMAGE_TYPE_ORF = 7;
    static final int IMAGE_TYPE_PEF = 8;
    static final int IMAGE_TYPE_PNG = 13;
    static final int IMAGE_TYPE_RAF = 9;
    static final int IMAGE_TYPE_RW2 = 10;
    static final int IMAGE_TYPE_SRW = 11;
    static final int IMAGE_TYPE_UNKNOWN = 0;
    static final int IMAGE_TYPE_WEBP = 14;
    static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final Pattern NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, 88, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(new Integer[]{1, 6, 3, 8});
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    private static final int SKIP_BUFFER_SIZE = 8192;
    static final byte START_CODE = 42;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    @RestrictTo
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, 88, 73, 70};
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte WEBP_VP8L_SIGNATURE = 47;
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, START_CODE};
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;

    public static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        public void writeByte(int i) throws IOException {
            this.mOutputStream.write(i);
        }

        public void writeInt(int i) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write(i & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i >>> 24) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write(i & 255);
            }
        }

        public void writeShort(short s) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write(s & 255);
                this.mOutputStream.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s >>> 8) & 255);
                this.mOutputStream.write(s & 255);
            }
        }

        public void writeUnsignedInt(long j) throws IOException {
            if (j <= 4294967295L) {
                writeInt((int) j);
                return;
            }
            throw new IllegalArgumentException("val is larger than the maximum value of a 32-bit unsigned integer");
        }

        public void writeUnsignedShort(int i) throws IOException {
            if (i <= 65535) {
                writeShort((short) i);
                return;
            }
            throw new IllegalArgumentException("val is larger than the maximum value of a 16-bit unsigned integer");
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mOutputStream.write(bArr, i, i2);
        }
    }

    public static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(int i, int i2, byte[] bArr) {
            this(i, i2, -1, bArr);
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes2 = str.getBytes(ExifInterface.ASCII);
                return new ExifAttribute(1, bytes2.length, bytes2);
            }
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes2 = (str + 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes2.length, bytes2);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (value instanceof String) {
                return Double.parseDouble((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) value;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (value instanceof String) {
                return Integer.parseInt((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                    }
                }
                return sb.toString();
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                    }
                }
                return sb.toString();
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                    }
                }
                return sb.toString();
            } else if (!(value instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) value;
                while (i < rationalArr.length) {
                    sb.append(rationalArr[i].numerator);
                    sb.append('/');
                    sb.append(rationalArr[i].denominator);
                    i++;
                    if (i != rationalArr.length) {
                        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:162:0x018f A[SYNTHETIC, Splitter:B:162:0x018f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object getValue(java.nio.ByteOrder r12) {
            /*
                r11 = this;
                r0 = 0
                r1 = 1
                java.lang.String r2 = "IOException occurred while closing InputStream"
                java.lang.String r3 = "ExifInterface"
                r4 = 0
                androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r5 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                byte[] r6 = r11.bytes     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                r5.<init>((byte[]) r6)     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                r5.setByteOrder(r12)     // Catch:{ IOException -> 0x0033 }
                int r12 = r11.format     // Catch:{ IOException -> 0x0033 }
                switch(r12) {
                    case 1: goto L_0x0149;
                    case 2: goto L_0x0103;
                    case 3: goto L_0x00ea;
                    case 4: goto L_0x00d1;
                    case 5: goto L_0x00af;
                    case 6: goto L_0x0149;
                    case 7: goto L_0x0103;
                    case 8: goto L_0x0096;
                    case 9: goto L_0x007d;
                    case 10: goto L_0x0059;
                    case 11: goto L_0x003f;
                    case 12: goto L_0x001f;
                    default: goto L_0x0016;
                }
            L_0x0016:
                r5.close()     // Catch:{ IOException -> 0x001a }
                goto L_0x001e
            L_0x001a:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x001e:
                return r4
            L_0x001f:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                double[] r12 = new double[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0023:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0036
                double r6 = r5.readDouble()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0023
            L_0x002f:
                r11 = move-exception
                r4 = r5
                goto L_0x018d
            L_0x0033:
                r11 = move-exception
                goto L_0x017d
            L_0x0036:
                r5.close()     // Catch:{ IOException -> 0x003a }
                goto L_0x003e
            L_0x003a:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x003e:
                return r12
            L_0x003f:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                double[] r12 = new double[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0043:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0050
                float r6 = r5.readFloat()     // Catch:{ IOException -> 0x0033 }
                double r6 = (double) r6     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0043
            L_0x0050:
                r5.close()     // Catch:{ IOException -> 0x0054 }
                goto L_0x0058
            L_0x0054:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x0058:
                return r12
            L_0x0059:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational[] r12 = new androidx.exifinterface.media.ExifInterface.Rational[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x005d:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0074
                int r6 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                long r6 = (long) r6     // Catch:{ IOException -> 0x0033 }
                int r8 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                long r8 = (long) r8     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0033 }
                r10.<init>(r6, r8)     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r10     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x005d
            L_0x0074:
                r5.close()     // Catch:{ IOException -> 0x0078 }
                goto L_0x007c
            L_0x0078:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x007c:
                return r12
            L_0x007d:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0081:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x008d
                int r6 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0081
            L_0x008d:
                r5.close()     // Catch:{ IOException -> 0x0091 }
                goto L_0x0095
            L_0x0091:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x0095:
                return r12
            L_0x0096:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x009a:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00a6
                short r6 = r5.readShort()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x009a
            L_0x00a6:
                r5.close()     // Catch:{ IOException -> 0x00aa }
                goto L_0x00ae
            L_0x00aa:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x00ae:
                return r12
            L_0x00af:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational[] r12 = new androidx.exifinterface.media.ExifInterface.Rational[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00b3:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00c8
                long r6 = r5.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
                long r8 = r5.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0033 }
                r10.<init>(r6, r8)     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r10     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00b3
            L_0x00c8:
                r5.close()     // Catch:{ IOException -> 0x00cc }
                goto L_0x00d0
            L_0x00cc:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x00d0:
                return r12
            L_0x00d1:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                long[] r12 = new long[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00d5:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00e1
                long r6 = r5.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00d5
            L_0x00e1:
                r5.close()     // Catch:{ IOException -> 0x00e5 }
                goto L_0x00e9
            L_0x00e5:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x00e9:
                return r12
            L_0x00ea:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00ee:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00fa
                int r6 = r5.readUnsignedShort()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00ee
            L_0x00fa:
                r5.close()     // Catch:{ IOException -> 0x00fe }
                goto L_0x0102
            L_0x00fe:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x0102:
                return r12
            L_0x0103:
                int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                byte[] r6 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0033 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0033 }
                if (r12 < r6) goto L_0x011c
                r12 = r0
            L_0x010b:
                byte[] r6 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0033 }
                int r7 = r6.length     // Catch:{ IOException -> 0x0033 }
                if (r12 >= r7) goto L_0x011b
                byte[] r7 = r11.bytes     // Catch:{ IOException -> 0x0033 }
                byte r7 = r7[r12]     // Catch:{ IOException -> 0x0033 }
                byte r6 = r6[r12]     // Catch:{ IOException -> 0x0033 }
                if (r7 == r6) goto L_0x0119
                goto L_0x011c
            L_0x0119:
                int r12 = r12 + r1
                goto L_0x010b
            L_0x011b:
                int r0 = r6.length     // Catch:{ IOException -> 0x0033 }
            L_0x011c:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0033 }
                r12.<init>()     // Catch:{ IOException -> 0x0033 }
            L_0x0121:
                int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x013c
                byte[] r6 = r11.bytes     // Catch:{ IOException -> 0x0033 }
                byte r6 = r6[r0]     // Catch:{ IOException -> 0x0033 }
                if (r6 != 0) goto L_0x012c
                goto L_0x013c
            L_0x012c:
                r7 = 32
                if (r6 < r7) goto L_0x0135
                char r6 = (char) r6     // Catch:{ IOException -> 0x0033 }
                r12.append(r6)     // Catch:{ IOException -> 0x0033 }
                goto L_0x013a
            L_0x0135:
                r6 = 63
                r12.append(r6)     // Catch:{ IOException -> 0x0033 }
            L_0x013a:
                int r0 = r0 + r1
                goto L_0x0121
            L_0x013c:
                java.lang.String r11 = r12.toString()     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0144 }
                goto L_0x0148
            L_0x0144:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x0148:
                return r11
            L_0x0149:
                byte[] r11 = r11.bytes     // Catch:{ IOException -> 0x0033 }
                int r12 = r11.length     // Catch:{ IOException -> 0x0033 }
                if (r12 != r1) goto L_0x0169
                byte r12 = r11[r0]     // Catch:{ IOException -> 0x0033 }
                if (r12 < 0) goto L_0x0169
                if (r12 > r1) goto L_0x0169
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
                int r12 = r12 + 48
                char r12 = (char) r12     // Catch:{ IOException -> 0x0033 }
                char[] r1 = new char[r1]     // Catch:{ IOException -> 0x0033 }
                r1[r0] = r12     // Catch:{ IOException -> 0x0033 }
                r11.<init>(r1)     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0164 }
                goto L_0x0168
            L_0x0164:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x0168:
                return r11
            L_0x0169:
                java.lang.String r12 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
                java.nio.charset.Charset r0 = androidx.exifinterface.media.ExifInterface.ASCII     // Catch:{ IOException -> 0x0033 }
                r12.<init>(r11, r0)     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0174 }
                goto L_0x0178
            L_0x0174:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x0178:
                return r12
            L_0x0179:
                r11 = move-exception
                goto L_0x018d
            L_0x017b:
                r11 = move-exception
                r5 = r4
            L_0x017d:
                java.lang.String r12 = "IOException occurred during reading a value"
                android.util.Log.w(r3, r12, r11)     // Catch:{ all -> 0x002f }
                if (r5 == 0) goto L_0x018c
                r5.close()     // Catch:{ IOException -> 0x0188 }
                goto L_0x018c
            L_0x0188:
                r11 = move-exception
                android.util.Log.e(r3, r2, r11)
            L_0x018c:
                return r4
            L_0x018d:
                if (r4 == 0) goto L_0x0197
                r4.close()     // Catch:{ IOException -> 0x0193 }
                goto L_0x0197
            L_0x0193:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x0197:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object");
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        public ExifAttribute(int i, int i2, long j, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytesOffset = j;
            this.bytes = bArr;
        }

        public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public static ExifAttribute createSLong(int i, ByteOrder byteOrder) {
            return createSLong(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    public static class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(double d) {
            this((long) (d * 10000.0d), 10000);
        }

        public double calculate() {
            return ((double) this.numerator) / ((double) this.denominator);
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }
    }

    static {
        ExifTag exifTag = r12;
        ExifTag exifTag2 = new ExifTag(TAG_NEW_SUBFILE_TYPE, DnsRecord.CLASS_NONE, 4);
        ExifTag exifTag3 = r6;
        ExifTag exifTag4 = new ExifTag(TAG_SUBFILE_TYPE, 255, 4);
        ExifTag exifTag5 = r6;
        ExifTag exifTag6 = new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4);
        ExifTag exifTag7 = r6;
        ExifTag exifTag8 = new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4);
        ExifTag exifTag9 = r6;
        ExifTag exifTag10 = new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3);
        ExifTag exifTag11 = r6;
        ExifTag exifTag12 = new ExifTag(TAG_COMPRESSION, 259, 3);
        ExifTag exifTag13 = r6;
        ExifTag exifTag14 = new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3);
        ExifTag exifTag15 = r6;
        ExifTag exifTag16 = new ExifTag(TAG_IMAGE_DESCRIPTION, UCarProto.Orientation.ORIENTATION_270_VALUE, 2);
        ExifTag exifTag17 = r6;
        ExifTag exifTag18 = new ExifTag(TAG_MAKE, 271, 2);
        ExifTag exifTag19 = r6;
        ExifTag exifTag20 = new ExifTag(TAG_MODEL, 272, 2);
        ExifTag exifTag21 = r6;
        ExifTag exifTag22 = new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4);
        ExifTag exifTag23 = r6;
        ExifTag exifTag24 = new ExifTag(TAG_ORIENTATION, 274, 3);
        ExifTag exifTag25 = r0;
        ExifTag exifTag26 = new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3);
        ExifTag exifTag27 = r0;
        ExifTag exifTag28 = new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4);
        ExifTag exifTag29 = r0;
        ExifTag exifTag30 = new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4);
        ExifTag exifTag31 = r0;
        ExifTag exifTag32 = new ExifTag(TAG_X_RESOLUTION, 282, 5);
        ExifTag exifTag33 = r0;
        ExifTag exifTag34 = new ExifTag(TAG_Y_RESOLUTION, DfuBaseService.NOTIFICATION_ID, 5);
        ExifTag exifTag35 = r0;
        ExifTag exifTag36 = new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3);
        ExifTag exifTag37 = r0;
        ExifTag exifTag38 = new ExifTag(TAG_RESOLUTION_UNIT, 296, 3);
        ExifTag exifTag39 = r0;
        ExifTag exifTag40 = new ExifTag(TAG_TRANSFER_FUNCTION, MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE, 3);
        ExifTag exifTag41 = r0;
        ExifTag exifTag42 = new ExifTag(TAG_SOFTWARE, 305, 2);
        ExifTag exifTag43 = r0;
        ExifTag exifTag44 = new ExifTag(TAG_DATETIME, 306, 2);
        ExifTag exifTag45 = r0;
        ExifTag exifTag46 = new ExifTag(TAG_ARTIST, 315, 2);
        ExifTag exifTag47 = r0;
        ExifTag exifTag48 = new ExifTag(TAG_WHITE_POINT, 318, 5);
        ExifTag exifTag49 = r0;
        ExifTag exifTag50 = new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5);
        ExifTag exifTag51 = r0;
        ExifTag exifTag52 = new ExifTag(TAG_SUB_IFD_POINTER, 330, 4);
        ExifTag exifTag53 = r0;
        ExifTag exifTag54 = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
        ExifTag exifTag55 = r0;
        ExifTag exifTag56 = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        ExifTag exifTag57 = r0;
        ExifTag exifTag58 = new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5);
        ExifTag exifTag59 = r0;
        ExifTag exifTag60 = new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3);
        ExifTag exifTag61 = r0;
        ExifTag exifTag62 = new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3);
        ExifTag exifTag63 = r0;
        ExifTag exifTag64 = new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5);
        ExifTag exifTag65 = r0;
        ExifTag exifTag66 = new ExifTag(TAG_COPYRIGHT, 33432, 2);
        ExifTag exifTag67 = r0;
        ExifTag exifTag68 = new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4);
        ExifTag exifTag69 = r0;
        ExifTag exifTag70 = new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4);
        ExifTag exifTag71 = r0;
        ExifTag exifTag72 = new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4);
        ExifTag exifTag73 = r0;
        ExifTag exifTag74 = new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4);
        ExifTag exifTag75 = r0;
        ExifTag exifTag76 = new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4);
        ExifTag exifTag77 = r0;
        ExifTag exifTag78 = new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4);
        ExifTag exifTag79 = r0;
        ExifTag exifTag80 = new ExifTag(TAG_RW2_ISO, 23, 3);
        ExifTag exifTag81 = r0;
        ExifTag exifTag82 = new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7);
        ExifTag exifTag83 = r0;
        ExifTag exifTag84 = new ExifTag(TAG_XMP, 700, 1);
        ExifTag[] exifTagArr = {exifTag, exifTag3, exifTag5, exifTag7, exifTag9, exifTag11, exifTag13, exifTag15, exifTag17, exifTag19, exifTag21, exifTag23, exifTag25, exifTag27, exifTag29, exifTag31, exifTag33, exifTag35, exifTag37, exifTag39, exifTag41, exifTag43, exifTag45, exifTag47, exifTag49, exifTag51, exifTag53, exifTag55, exifTag57, exifTag59, exifTag61, exifTag63, exifTag65, exifTag67, exifTag69, exifTag71, exifTag73, exifTag75, exifTag77, exifTag79, exifTag81, exifTag83};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag exifTag85 = r0;
        ExifTag exifTag86 = new ExifTag(TAG_EXPOSURE_TIME, 33434, 5);
        ExifTag exifTag87 = r0;
        ExifTag exifTag88 = new ExifTag(TAG_F_NUMBER, 33437, 5);
        ExifTag exifTag89 = r0;
        ExifTag exifTag90 = new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3);
        ExifTag exifTag91 = r0;
        ExifTag exifTag92 = new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2);
        ExifTag exifTag93 = r0;
        ExifTag exifTag94 = new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3);
        ExifTag exifTag95 = r0;
        ExifTag exifTag96 = new ExifTag(TAG_OECF, 34856, 7);
        ExifTag exifTag97 = r0;
        ExifTag exifTag98 = new ExifTag(TAG_SENSITIVITY_TYPE, 34864, 3);
        ExifTag exifTag99 = r0;
        ExifTag exifTag100 = new ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4);
        ExifTag exifTag101 = r0;
        ExifTag exifTag102 = new ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4);
        ExifTag exifTag103 = r0;
        ExifTag exifTag104 = new ExifTag(TAG_ISO_SPEED, 34867, 4);
        ExifTag exifTag105 = r0;
        ExifTag exifTag106 = new ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4);
        ExifTag exifTag107 = r0;
        ExifTag exifTag108 = new ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4);
        ExifTag exifTag109 = r0;
        ExifTag exifTag110 = new ExifTag(TAG_EXIF_VERSION, 36864, 2);
        ExifTag exifTag111 = r0;
        ExifTag exifTag112 = new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2);
        ExifTag exifTag113 = r0;
        ExifTag exifTag114 = new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2);
        ExifTag exifTag115 = r0;
        ExifTag exifTag116 = new ExifTag(TAG_OFFSET_TIME, 36880, 2);
        ExifTag exifTag117 = r0;
        ExifTag exifTag118 = new ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2);
        ExifTag exifTag119 = r0;
        ExifTag exifTag120 = new ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2);
        ExifTag exifTag121 = r0;
        ExifTag exifTag122 = new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7);
        ExifTag exifTag123 = r0;
        ExifTag exifTag124 = new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5);
        ExifTag exifTag125 = r0;
        ExifTag exifTag126 = new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10);
        ExifTag exifTag127 = r0;
        ExifTag exifTag128 = new ExifTag(TAG_APERTURE_VALUE, 37378, 5);
        ExifTag exifTag129 = r0;
        ExifTag exifTag130 = new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10);
        ExifTag exifTag131 = r0;
        ExifTag exifTag132 = new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10);
        ExifTag exifTag133 = r0;
        ExifTag exifTag134 = new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5);
        ExifTag exifTag135 = r0;
        ExifTag exifTag136 = new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5);
        ExifTag exifTag137 = r0;
        ExifTag exifTag138 = new ExifTag(TAG_METERING_MODE, 37383, 3);
        ExifTag exifTag139 = r0;
        ExifTag exifTag140 = new ExifTag(TAG_LIGHT_SOURCE, 37384, 3);
        ExifTag exifTag141 = r0;
        ExifTag exifTag142 = new ExifTag(TAG_FLASH, 37385, 3);
        ExifTag exifTag143 = r0;
        ExifTag exifTag144 = new ExifTag(TAG_FOCAL_LENGTH, 37386, 5);
        ExifTag exifTag145 = r0;
        ExifTag exifTag146 = new ExifTag(TAG_SUBJECT_AREA, 37396, 3);
        ExifTag exifTag147 = r0;
        ExifTag exifTag148 = new ExifTag(TAG_MAKER_NOTE, 37500, 7);
        ExifTag exifTag149 = r0;
        ExifTag exifTag150 = new ExifTag(TAG_USER_COMMENT, 37510, 7);
        ExifTag exifTag151 = r0;
        ExifTag exifTag152 = new ExifTag(TAG_SUBSEC_TIME, 37520, 2);
        ExifTag exifTag153 = r0;
        ExifTag exifTag154 = new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2);
        ExifTag exifTag155 = r0;
        ExifTag exifTag156 = new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2);
        ExifTag exifTag157 = r0;
        ExifTag exifTag158 = new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7);
        ExifTag exifTag159 = r0;
        ExifTag exifTag160 = new ExifTag(TAG_COLOR_SPACE, 40961, 3);
        ExifTag exifTag161 = r0;
        ExifTag exifTag162 = new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4);
        ExifTag exifTag163 = r0;
        ExifTag exifTag164 = new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4);
        ExifTag exifTag165 = r0;
        ExifTag exifTag166 = new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2);
        ExifTag exifTag167 = r0;
        ExifTag exifTag168 = new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4);
        ExifTag exifTag169 = r0;
        ExifTag exifTag170 = new ExifTag(TAG_FLASH_ENERGY, 41483, 5);
        ExifTag exifTag171 = r0;
        ExifTag exifTag172 = new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7);
        ExifTag exifTag173 = r0;
        ExifTag exifTag174 = new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5);
        ExifTag exifTag175 = r0;
        ExifTag exifTag176 = new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5);
        ExifTag exifTag177 = r0;
        ExifTag exifTag178 = new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3);
        ExifTag exifTag179 = r0;
        ExifTag exifTag180 = new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3);
        ExifTag exifTag181 = r0;
        ExifTag exifTag182 = new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5);
        ExifTag exifTag183 = r0;
        ExifTag exifTag184 = new ExifTag(TAG_SENSING_METHOD, 41495, 3);
        ExifTag exifTag185 = r0;
        ExifTag exifTag186 = new ExifTag(TAG_FILE_SOURCE, 41728, 7);
        ExifTag exifTag187 = r0;
        ExifTag exifTag188 = new ExifTag(TAG_SCENE_TYPE, 41729, 7);
        ExifTag exifTag189 = r0;
        ExifTag exifTag190 = new ExifTag(TAG_CFA_PATTERN, 41730, 7);
        ExifTag exifTag191 = r0;
        ExifTag exifTag192 = new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3);
        ExifTag exifTag193 = r0;
        ExifTag exifTag194 = new ExifTag(TAG_EXPOSURE_MODE, 41986, 3);
        ExifTag exifTag195 = r0;
        ExifTag exifTag196 = new ExifTag(TAG_WHITE_BALANCE, 41987, 3);
        ExifTag exifTag197 = r0;
        ExifTag exifTag198 = new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5);
        ExifTag exifTag199 = r0;
        ExifTag exifTag200 = new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3);
        ExifTag exifTag201 = r0;
        ExifTag exifTag202 = new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3);
        ExifTag exifTag203 = r0;
        ExifTag exifTag204 = new ExifTag(TAG_GAIN_CONTROL, 41991, 3);
        ExifTag exifTag205 = r0;
        ExifTag exifTag206 = new ExifTag(TAG_CONTRAST, 41992, 3);
        ExifTag exifTag207 = r0;
        ExifTag exifTag208 = new ExifTag(TAG_SATURATION, 41993, 3);
        ExifTag exifTag209 = r0;
        ExifTag exifTag210 = new ExifTag(TAG_SHARPNESS, 41994, 3);
        ExifTag exifTag211 = r0;
        ExifTag exifTag212 = new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7);
        ExifTag exifTag213 = r0;
        ExifTag exifTag214 = new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3);
        ExifTag exifTag215 = r0;
        ExifTag exifTag216 = new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2);
        ExifTag exifTag217 = r0;
        ExifTag exifTag218 = new ExifTag("CameraOwnerName", 42032, 2);
        ExifTag exifTag219 = r0;
        ExifTag exifTag220 = new ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2);
        ExifTag exifTag221 = r0;
        ExifTag exifTag222 = new ExifTag(TAG_LENS_SPECIFICATION, 42034, 5);
        ExifTag exifTag223 = r0;
        ExifTag exifTag224 = new ExifTag(TAG_LENS_MAKE, 42035, 2);
        ExifTag exifTag225 = r0;
        ExifTag exifTag226 = new ExifTag(TAG_LENS_MODEL, 42036, 2);
        ExifTag exifTag227 = r0;
        ExifTag exifTag228 = new ExifTag(TAG_GAMMA, 42240, 5);
        ExifTag exifTag229 = r0;
        ExifTag exifTag230 = new ExifTag(TAG_DNG_VERSION, 50706, 1);
        ExifTag exifTag231 = r0;
        ExifTag exifTag232 = new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4);
        ExifTag[] exifTagArr2 = {exifTag85, exifTag87, exifTag89, exifTag91, exifTag93, exifTag95, exifTag97, exifTag99, exifTag101, exifTag103, exifTag105, exifTag107, exifTag109, exifTag111, exifTag113, exifTag115, exifTag117, exifTag119, exifTag121, exifTag123, exifTag125, exifTag127, exifTag129, exifTag131, exifTag133, exifTag135, exifTag137, exifTag139, exifTag141, exifTag143, exifTag145, exifTag147, exifTag149, exifTag151, exifTag153, exifTag155, exifTag157, exifTag159, exifTag161, exifTag163, exifTag165, exifTag167, exifTag169, exifTag171, exifTag173, exifTag175, exifTag177, exifTag179, exifTag181, exifTag183, exifTag185, exifTag187, exifTag189, exifTag191, exifTag193, exifTag195, exifTag197, exifTag199, exifTag201, exifTag203, exifTag205, exifTag207, exifTag209, exifTag211, exifTag213, exifTag215, exifTag217, exifTag219, exifTag221, exifTag223, exifTag225, exifTag227, exifTag229, exifTag231};
        IFD_EXIF_TAGS = exifTagArr2;
        ExifTag exifTag233 = r0;
        ExifTag exifTag234 = new ExifTag(TAG_GPS_VERSION_ID, 0, 1);
        ExifTag exifTag235 = r0;
        ExifTag exifTag236 = new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2);
        ExifTag exifTag237 = r0;
        ExifTag exifTag238 = new ExifTag(TAG_GPS_LATITUDE, 2, 5, 10);
        ExifTag exifTag239 = r0;
        ExifTag exifTag240 = new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2);
        ExifTag exifTag241 = r0;
        ExifTag exifTag242 = new ExifTag(TAG_GPS_LONGITUDE, 4, 5, 10);
        ExifTag exifTag243 = r0;
        ExifTag exifTag244 = new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1);
        ExifTag exifTag245 = r0;
        ExifTag exifTag246 = new ExifTag(TAG_GPS_ALTITUDE, 6, 5);
        ExifTag exifTag247 = r0;
        ExifTag exifTag248 = new ExifTag(TAG_GPS_TIMESTAMP, 7, 5);
        ExifTag exifTag249 = r0;
        ExifTag exifTag250 = new ExifTag(TAG_GPS_SATELLITES, 8, 2);
        ExifTag exifTag251 = r0;
        ExifTag exifTag252 = new ExifTag(TAG_GPS_STATUS, 9, 2);
        ExifTag exifTag253 = r0;
        ExifTag exifTag254 = new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2);
        ExifTag exifTag255 = r0;
        ExifTag exifTag256 = new ExifTag(TAG_GPS_DOP, 11, 5);
        ExifTag exifTag257 = r0;
        ExifTag exifTag258 = new ExifTag(TAG_GPS_SPEED_REF, 12, 2);
        ExifTag exifTag259 = r0;
        ExifTag exifTag260 = new ExifTag(TAG_GPS_SPEED, 13, 5);
        ExifTag exifTag261 = r0;
        ExifTag exifTag262 = new ExifTag(TAG_GPS_TRACK_REF, 14, 2);
        ExifTag exifTag263 = r0;
        ExifTag exifTag264 = new ExifTag(TAG_GPS_TRACK, 15, 5);
        ExifTag exifTag265 = r0;
        ExifTag exifTag266 = new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2);
        ExifTag exifTag267 = r0;
        ExifTag exifTag268 = new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5);
        ExifTag exifTag269 = r0;
        ExifTag exifTag270 = new ExifTag(TAG_GPS_MAP_DATUM, 18, 2);
        ExifTag exifTag271 = r0;
        ExifTag exifTag272 = new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2);
        ExifTag exifTag273 = r0;
        ExifTag exifTag274 = new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5);
        ExifTag exifTag275 = r0;
        ExifTag exifTag276 = new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2);
        ExifTag exifTag277 = r0;
        ExifTag exifTag278 = new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5);
        ExifTag exifTag279 = r0;
        ExifTag exifTag280 = new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2);
        ExifTag exifTag281 = r0;
        ExifTag exifTag282 = new ExifTag(TAG_GPS_DEST_BEARING, 24, 5);
        ExifTag exifTag283 = r0;
        ExifTag exifTag284 = new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2);
        ExifTag exifTag285 = r0;
        ExifTag exifTag286 = new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5);
        ExifTag exifTag287 = r0;
        ExifTag exifTag288 = new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7);
        ExifTag exifTag289 = r0;
        ExifTag exifTag290 = new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7);
        ExifTag exifTag291 = r0;
        ExifTag exifTag292 = new ExifTag(TAG_GPS_DATESTAMP, 29, 2);
        ExifTag exifTag293 = r0;
        ExifTag exifTag294 = new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3);
        ExifTag exifTag295 = r0;
        ExifTag exifTag296 = new ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5);
        ExifTag[] exifTagArr3 = {exifTag233, exifTag235, exifTag237, exifTag239, exifTag241, exifTag243, exifTag245, exifTag247, exifTag249, exifTag251, exifTag253, exifTag255, exifTag257, exifTag259, exifTag261, exifTag263, exifTag265, exifTag267, exifTag269, exifTag271, exifTag273, exifTag275, exifTag277, exifTag279, exifTag281, exifTag283, exifTag285, exifTag287, exifTag289, exifTag291, exifTag293, exifTag295};
        IFD_GPS_TAGS = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        ExifTag exifTag297 = r0;
        ExifTag exifTag298 = new ExifTag(TAG_NEW_SUBFILE_TYPE, DnsRecord.CLASS_NONE, 4);
        ExifTag exifTag299 = r0;
        ExifTag exifTag300 = new ExifTag(TAG_SUBFILE_TYPE, 255, 4);
        ExifTag exifTag301 = r0;
        ExifTag exifTag302 = new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4);
        ExifTag exifTag303 = r0;
        ExifTag exifTag304 = new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4);
        ExifTag exifTag305 = r0;
        ExifTag exifTag306 = new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3);
        ExifTag exifTag307 = r0;
        ExifTag exifTag308 = new ExifTag(TAG_COMPRESSION, 259, 3);
        ExifTag exifTag309 = r0;
        ExifTag exifTag310 = new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3);
        ExifTag exifTag311 = r0;
        ExifTag exifTag312 = new ExifTag(TAG_IMAGE_DESCRIPTION, UCarProto.Orientation.ORIENTATION_270_VALUE, 2);
        ExifTag exifTag313 = r0;
        ExifTag exifTag314 = new ExifTag(TAG_MAKE, 271, 2);
        ExifTag exifTag315 = r0;
        ExifTag exifTag316 = new ExifTag(TAG_MODEL, 272, 2);
        ExifTag exifTag317 = r0;
        ExifTag exifTag318 = new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4);
        ExifTag exifTag319 = r0;
        ExifTag exifTag320 = new ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3);
        ExifTag exifTag321 = r0;
        ExifTag exifTag322 = new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3);
        ExifTag exifTag323 = r0;
        ExifTag exifTag324 = new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4);
        ExifTag exifTag325 = r0;
        ExifTag exifTag326 = new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4);
        ExifTag exifTag327 = r0;
        ExifTag exifTag328 = new ExifTag(TAG_X_RESOLUTION, 282, 5);
        ExifTag exifTag329 = r0;
        ExifTag exifTag330 = new ExifTag(TAG_Y_RESOLUTION, DfuBaseService.NOTIFICATION_ID, 5);
        ExifTag exifTag331 = r0;
        ExifTag exifTag332 = new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3);
        ExifTag exifTag333 = r0;
        ExifTag exifTag334 = new ExifTag(TAG_RESOLUTION_UNIT, 296, 3);
        ExifTag exifTag335 = r0;
        ExifTag exifTag336 = new ExifTag(TAG_TRANSFER_FUNCTION, MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE, 3);
        ExifTag exifTag337 = r0;
        ExifTag exifTag338 = new ExifTag(TAG_SOFTWARE, 305, 2);
        ExifTag exifTag339 = r0;
        ExifTag exifTag340 = new ExifTag(TAG_DATETIME, 306, 2);
        ExifTag exifTag341 = r0;
        ExifTag exifTag342 = new ExifTag(TAG_ARTIST, 315, 2);
        ExifTag exifTag343 = r0;
        ExifTag exifTag344 = new ExifTag(TAG_WHITE_POINT, 318, 5);
        ExifTag exifTag345 = r0;
        ExifTag exifTag346 = new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5);
        ExifTag exifTag347 = r0;
        ExifTag exifTag348 = new ExifTag(TAG_SUB_IFD_POINTER, 330, 4);
        ExifTag exifTag349 = r0;
        ExifTag exifTag350 = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
        ExifTag exifTag351 = r0;
        ExifTag exifTag352 = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        ExifTag exifTag353 = r0;
        ExifTag exifTag354 = new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5);
        ExifTag exifTag355 = r0;
        ExifTag exifTag356 = new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3);
        ExifTag exifTag357 = r0;
        ExifTag exifTag358 = new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3);
        ExifTag exifTag359 = r0;
        ExifTag exifTag360 = new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5);
        ExifTag exifTag361 = r0;
        ExifTag exifTag362 = new ExifTag(TAG_COPYRIGHT, 33432, 2);
        ExifTag exifTag363 = r0;
        ExifTag exifTag364 = new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4);
        ExifTag exifTag365 = r0;
        ExifTag exifTag366 = new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4);
        ExifTag exifTag367 = r0;
        ExifTag exifTag368 = new ExifTag(TAG_DNG_VERSION, 50706, 1);
        ExifTag exifTag369 = r0;
        ExifTag exifTag370 = new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4);
        ExifTag[] exifTagArr5 = {exifTag297, exifTag299, exifTag301, exifTag303, exifTag305, exifTag307, exifTag309, exifTag311, exifTag313, exifTag315, exifTag317, exifTag319, exifTag321, exifTag323, exifTag325, exifTag327, exifTag329, exifTag331, exifTag333, exifTag335, exifTag337, exifTag339, exifTag341, exifTag343, exifTag345, exifTag347, exifTag349, exifTag351, exifTag353, exifTag355, exifTag357, exifTag359, exifTag361, exifTag363, exifTag365, exifTag367, exifTag369};
        IFD_THUMBNAIL_TAGS = exifTagArr5;
        ExifTag[] exifTagArr6 = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifTagArr9;
        ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        EXIF_TAGS = exifTagArr10;
        sExifTagMapsForReading = new HashMap[exifTagArr10.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        sFormatterPrimary = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        sFormatterSecondary = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            ExifTag[][] exifTagArr11 = EXIF_TAGS;
            if (i < exifTagArr11.length) {
                sExifTagMapsForReading[i] = new HashMap<>();
                sExifTagMapsForWriting[i] = new HashMap<>();
                for (ExifTag exifTag371 : exifTagArr11[i]) {
                    sExifTagMapsForReading[i].put(Integer.valueOf(exifTag371.number), exifTag371);
                    sExifTagMapsForWriting[i].put(exifTag371.name, exifTag371);
                }
                i++;
            } else {
                HashMap<Integer, Integer> hashMap = sExifPointerTagMap;
                ExifTag[] exifTagArr12 = EXIF_POINTER_TAGS;
                hashMap.put(Integer.valueOf(exifTagArr12[0].number), 5);
                hashMap.put(Integer.valueOf(exifTagArr12[1].number), 1);
                hashMap.put(Integer.valueOf(exifTagArr12[2].number), 2);
                hashMap.put(Integer.valueOf(exifTagArr12[3].number), 3);
                hashMap.put(Integer.valueOf(exifTagArr12[4].number), 7);
                hashMap.put(Integer.valueOf(exifTagArr12[5].number), 8);
                return;
            }
        }
    }

    public ExifInterface(@NonNull File file) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            initForFilename(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
    }

    private String convertDecimalDegree(double d) {
        long j = (long) d;
        double d2 = d - ((double) j);
        long j2 = (long) (d2 * 60.0d);
        long round = Math.round((d2 - (((double) j2) / 60.0d)) * 3600.0d * 1.0E7d);
        return j + "/1," + j2 + "/1," + round + "/10000000";
    }

    private static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH)) {
                if (!str2.equals(LONGITUDE_WEST)) {
                    if (!str2.equals("N")) {
                        if (!str2.equals(LONGITUDE_EAST)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        while (true) {
            byte[] bArr3 = new byte[4];
            byteOrderedDataInputStream.readFully(bArr3);
            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws IOException {
        int readInt = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.writeInt(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        if (str != null) {
            if (TAG_ISO_SPEED_RATINGS.equals(str)) {
                if (DEBUG) {
                    Log.d(TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            for (int i = 0; i < EXIF_TAGS.length; i++) {
                ExifAttribute exifAttribute = this.mAttributes[i].get(str);
                if (exifAttribute != null) {
                    return exifAttribute;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:45|46|47) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0126, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0127, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012a, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0040, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x011f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getHeifAttributes(final androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            androidx.exifinterface.media.ExifInterface$1 r2 = new androidx.exifinterface.media.ExifInterface$1     // Catch:{ RuntimeException -> 0x011f }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x011f }
            androidx.exifinterface.media.ExifInterfaceUtils.Api23Impl.setDataSource(r1, r2)     // Catch:{ RuntimeException -> 0x011f }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x011f }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x011f }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x011f }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x011f }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x011f }
            if (r4 == 0) goto L_0x0043
            r0 = 29
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x011f }
            r4 = 30
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x011f }
            r5 = 31
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x011f }
            goto L_0x005f
        L_0x0040:
            r12 = move-exception
            goto L_0x0127
        L_0x0043:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x011f }
            if (r0 == 0) goto L_0x005c
            r0 = 18
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x011f }
            r4 = 19
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x011f }
            r5 = 24
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x011f }
            goto L_0x005f
        L_0x005c:
            r0 = 0
            r4 = r0
            r5 = r4
        L_0x005f:
            r6 = 0
            if (r0 == 0) goto L_0x0075
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r12.mAttributes     // Catch:{ RuntimeException -> 0x011f }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x011f }
            java.nio.ByteOrder r10 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x011f }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r9, (java.nio.ByteOrder) r10)     // Catch:{ RuntimeException -> 0x011f }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x011f }
        L_0x0075:
            if (r4 == 0) goto L_0x008a
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r12.mAttributes     // Catch:{ RuntimeException -> 0x011f }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x011f }
            java.nio.ByteOrder r10 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x011f }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r9, (java.nio.ByteOrder) r10)     // Catch:{ RuntimeException -> 0x011f }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x011f }
        L_0x008a:
            r7 = 6
            if (r5 == 0) goto L_0x00b4
            int r8 = java.lang.Integer.parseInt(r5)     // Catch:{ RuntimeException -> 0x011f }
            r9 = 90
            if (r8 == r9) goto L_0x00a4
            r9 = 180(0xb4, float:2.52E-43)
            if (r8 == r9) goto L_0x00a2
            r9 = 270(0x10e, float:3.78E-43)
            if (r8 == r9) goto L_0x009f
            r8 = 1
            goto L_0x00a5
        L_0x009f:
            r8 = 8
            goto L_0x00a5
        L_0x00a2:
            r8 = 3
            goto L_0x00a5
        L_0x00a4:
            r8 = r7
        L_0x00a5:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r9 = r12.mAttributes     // Catch:{ RuntimeException -> 0x011f }
            r9 = r9[r6]     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x011f }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r8, (java.nio.ByteOrder) r11)     // Catch:{ RuntimeException -> 0x011f }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x011f }
        L_0x00b4:
            if (r2 == 0) goto L_0x00f1
            if (r3 == 0) goto L_0x00f1
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x011f }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x011f }
            if (r3 <= r7) goto L_0x00e9
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x011f }
            r13.seek(r8)     // Catch:{ RuntimeException -> 0x011f }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x011f }
            r13.readFully(r8)     // Catch:{ RuntimeException -> 0x011f }
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = IDENTIFIER_EXIF_APP1     // Catch:{ RuntimeException -> 0x011f }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x011f }
            if (r7 == 0) goto L_0x00e1
            byte[] r3 = new byte[r3]     // Catch:{ RuntimeException -> 0x011f }
            r13.readFully(r3)     // Catch:{ RuntimeException -> 0x011f }
            r12.mOffsetToExifData = r2     // Catch:{ RuntimeException -> 0x011f }
            r12.readExifSegment(r3, r6)     // Catch:{ RuntimeException -> 0x011f }
            goto L_0x00f1
        L_0x00e1:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r13 = "Invalid identifier"
            r12.<init>(r13)     // Catch:{ RuntimeException -> 0x011f }
            throw r12     // Catch:{ RuntimeException -> 0x011f }
        L_0x00e9:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r13 = "Invalid exif length"
            r12.<init>(r13)     // Catch:{ RuntimeException -> 0x011f }
            throw r12     // Catch:{ RuntimeException -> 0x011f }
        L_0x00f1:
            boolean r12 = DEBUG     // Catch:{ RuntimeException -> 0x011f }
            if (r12 == 0) goto L_0x011b
            java.lang.String r12 = "ExifInterface"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x011f }
            r13.<init>()     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r2 = "Heif meta: "
            r13.append(r2)     // Catch:{ RuntimeException -> 0x011f }
            r13.append(r0)     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r0 = "x"
            r13.append(r0)     // Catch:{ RuntimeException -> 0x011f }
            r13.append(r4)     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r0 = ", rotation "
            r13.append(r0)     // Catch:{ RuntimeException -> 0x011f }
            r13.append(r5)     // Catch:{ RuntimeException -> 0x011f }
            java.lang.String r13 = r13.toString()     // Catch:{ RuntimeException -> 0x011f }
            android.util.Log.d(r12, r13)     // Catch:{ RuntimeException -> 0x011f }
        L_0x011b:
            r1.release()
            return
        L_0x011f:
            java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0040 }
            java.lang.String r13 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r12.<init>(r13)     // Catch:{ all -> 0x0040 }
            throw r12     // Catch:{ all -> 0x0040 }
        L_0x0127:
            r1.release()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getHeifAttributes(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0170 A[LOOP:0: B:8:0x0037->B:56:0x0170, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0177 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r22, int r23, int r24) throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            boolean r3 = DEBUG
            java.lang.String r4 = "ExifInterface"
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getJpegAttributes starting with: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r4, r3)
        L_0x0020:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.setByteOrder(r3)
            byte r3 = r22.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r3 != r6) goto L_0x01c4
            byte r7 = r22.readByte()
            r8 = -40
            if (r7 != r8) goto L_0x01a9
            r3 = 2
        L_0x0037:
            byte r5 = r22.readByte()
            if (r5 != r6) goto L_0x018c
            byte r5 = r22.readByte()
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x005f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Found JPEG segment indicator: "
            r8.append(r9)
            r9 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r4, r8)
        L_0x005f:
            r8 = -39
            if (r5 == r8) goto L_0x0186
            r8 = -38
            if (r5 != r8) goto L_0x0069
            goto L_0x0186
        L_0x0069:
            int r8 = r22.readUnsignedShort()
            int r9 = r8 + -2
            r10 = 4
            int r3 = r3 + r10
            if (r7 == 0) goto L_0x009a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "JPEG segment: "
            r7.append(r11)
            r11 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r7.append(r11)
            java.lang.String r11 = " (length: "
            r7.append(r11)
            r7.append(r8)
            java.lang.String r11 = ")"
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r4, r7)
        L_0x009a:
            java.lang.String r7 = "Invalid length"
            if (r9 < 0) goto L_0x017f
            r11 = -31
            r12 = 1
            r13 = 0
            if (r5 == r11) goto L_0x0112
            r11 = -2
            if (r5 == r11) goto L_0x00ef
            switch(r5) {
                case -64: goto L_0x00b7;
                case -63: goto L_0x00b7;
                case -62: goto L_0x00b7;
                case -61: goto L_0x00b7;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            switch(r5) {
                case -59: goto L_0x00b7;
                case -58: goto L_0x00b7;
                case -57: goto L_0x00b7;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            switch(r5) {
                case -55: goto L_0x00b7;
                case -54: goto L_0x00b7;
                case -53: goto L_0x00b7;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            switch(r5) {
                case -51: goto L_0x00b7;
                case -50: goto L_0x00b7;
                case -49: goto L_0x00b7;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            r20 = r7
            goto L_0x016e
        L_0x00b7:
            r1.skipFully(r12)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r5 = r0.mAttributes
            r5 = r5[r2]
            if (r2 == r10) goto L_0x00c3
            java.lang.String r9 = "ImageLength"
            goto L_0x00c5
        L_0x00c3:
            java.lang.String r9 = "ThumbnailImageLength"
        L_0x00c5:
            int r11 = r22.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r11, (java.nio.ByteOrder) r13)
            r5.put(r9, r11)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r5 = r0.mAttributes
            r5 = r5[r2]
            if (r2 == r10) goto L_0x00dc
            java.lang.String r9 = "ImageWidth"
            goto L_0x00de
        L_0x00dc:
            java.lang.String r9 = "ThumbnailImageWidth"
        L_0x00de:
            int r10 = r22.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r10 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r10, (java.nio.ByteOrder) r12)
            r5.put(r9, r10)
            int r9 = r8 + -7
            goto L_0x00b3
        L_0x00ef:
            byte[] r5 = new byte[r9]
            r1.readFully(r5)
            java.lang.String r8 = "UserComment"
            java.lang.String r9 = r0.getAttribute(r8)
            if (r9 != 0) goto L_0x010e
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r9 = r0.mAttributes
            r9 = r9[r12]
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = ASCII
            r10.<init>(r5, r11)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(r10)
            r9.put(r8, r5)
        L_0x010e:
            r20 = r7
        L_0x0110:
            r9 = r13
            goto L_0x016e
        L_0x0112:
            byte[] r5 = new byte[r9]
            r1.readFully(r5)
            int r8 = r3 + r9
            byte[] r10 = IDENTIFIER_EXIF_APP1
            boolean r11 = androidx.exifinterface.media.ExifInterfaceUtils.startsWith(r5, r10)
            if (r11 == 0) goto L_0x013a
            int r11 = r10.length
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r11, r9)
            int r3 = r23 + r3
            int r9 = r10.length
            int r3 = r3 + r9
            r0.mOffsetToExifData = r3
            r0.readExifSegment(r5, r2)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r3 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            r3.<init>((byte[]) r5)
            r0.setThumbnailData(r3)
        L_0x0137:
            r20 = r7
            goto L_0x016c
        L_0x013a:
            byte[] r10 = IDENTIFIER_XMP_APP1
            boolean r11 = androidx.exifinterface.media.ExifInterfaceUtils.startsWith(r5, r10)
            if (r11 == 0) goto L_0x0137
            int r11 = r10.length
            int r3 = r3 + r11
            int r10 = r10.length
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r10, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r10 = r0.getAttribute(r9)
            if (r10 != 0) goto L_0x0137
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r10 = r0.mAttributes
            r10 = r10[r13]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            int r15 = r5.length
            r20 = r7
            long r6 = (long) r3
            r3 = 1
            r14 = r11
            r16 = r15
            r15 = r3
            r17 = r6
            r19 = r5
            r14.<init>(r15, r16, r17, r19)
            r10.put(r9, r11)
            r0.mXmpIsFromSeparateMarker = r12
        L_0x016c:
            r3 = r8
            goto L_0x0110
        L_0x016e:
            if (r9 < 0) goto L_0x0177
            r1.skipFully(r9)
            int r3 = r3 + r9
            r6 = -1
            goto L_0x0037
        L_0x0177:
            java.io.IOException r0 = new java.io.IOException
            r1 = r20
            r0.<init>(r1)
            throw r0
        L_0x017f:
            r1 = r7
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r1)
            throw r0
        L_0x0186:
            java.nio.ByteOrder r0 = r0.mExifByteOrder
            r1.setByteOrder(r0)
            return
        L_0x018c:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid marker:"
            r1.append(r2)
            r2 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01a9:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r2 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01c4:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r2 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        return isWebpFormat(bArr) ? 14 : 0;
    }

    private void getOrfAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        int i;
        int i2;
        getRawAttributes(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.seek(0);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.seek(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.seek(12);
            }
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifAttribute exifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (!(exifAttribute2 == null || exifAttribute3 == null)) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Log.w(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 > i4 && (i = iArr[3]) > (i2 = iArr[1])) {
                    int i5 = (i3 - i4) + 1;
                    int i6 = (i - i2) + 1;
                    if (i5 < i6) {
                        int i7 = i5 + i6;
                        i6 = i7 - i6;
                        i5 = i7 - i6;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i5, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i6, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort2);
                }
            }
        }
    }

    private void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                byte[] bArr2 = new byte[4];
                byteOrderedDataInputStream.readFully(bArr2);
                int i = length + 8;
                if (i == 16) {
                    if (!Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                }
                if (!Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                    if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                        byte[] bArr3 = new byte[readInt];
                        byteOrderedDataInputStream.readFully(bArr3);
                        int readInt2 = byteOrderedDataInputStream.readInt();
                        CRC32 crc32 = new CRC32();
                        crc32.update(bArr2);
                        crc32.update(bArr3);
                        if (((int) crc32.getValue()) == readInt2) {
                            this.mOffsetToExifData = i;
                            readExifSegment(bArr3, 0);
                            validateImages();
                            setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                            return;
                        }
                        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                    }
                    int i2 = readInt + 4;
                    byteOrderedDataInputStream.skipFully(i2);
                    length = i + i2;
                } else {
                    return;
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.skipFully(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.readFully(bArr);
        byteOrderedDataInputStream.readFully(bArr2);
        byteOrderedDataInputStream.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        byteOrderedDataInputStream.skipFully(i - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.readFully(bArr4);
        getJpegAttributes(new ByteOrderedDataInputStream(bArr4), i, 5);
        byteOrderedDataInputStream.skipFully(i3 - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (z) {
            Log.d(TAG, "numberOfDirectoryEntry: " + readInt);
        }
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort((int) readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort((int) readShort2, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort2);
                if (DEBUG) {
                    Log.d(TAG, "Updated to length: " + readShort + ", width: " + readShort2);
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipFully(readUnsignedShort2);
        }
    }

    private void getRawAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 5);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType == 8 && (exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            seekableByteOrderedDataInputStream2.skipFully(6);
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
            if (exifAttribute2 != null) {
                this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute2);
            }
        }
    }

    private void getRw2Attributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        getRawAttributes(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW);
        if (exifAttribute != null) {
            getJpegAttributes(new ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        ExifAttribute exifAttribute2 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute3 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute2 != null && exifAttribute3 == null) {
            this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute2);
        }
    }

    private void getStandaloneAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        seekableByteOrderedDataInputStream.skipFully(bArr.length);
        byte[] bArr2 = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        this.mOffsetToExifData = bArr.length;
        readExifSegment(bArr2, 0);
    }

    private void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_1.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                byteOrderedDataInputStream.readFully(bArr2);
                int readInt2 = byteOrderedDataInputStream.readInt();
                int i = length + 8;
                if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    byteOrderedDataInputStream.readFully(bArr3);
                    this.mOffsetToExifData = i;
                    readExifSegment(bArr3, 0);
                    setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                    return;
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i + readInt2;
                if (length != readInt) {
                    if (length <= readInt) {
                        byteOrderedDataInputStream.skipFully(readInt2);
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    return;
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:67|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        java.lang.Double.parseDouble(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x014a, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0150, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x013c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r10) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r10.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r10 = r10.split(r0, r6)
            r0 = r10[r2]
            android.util.Pair r0 = guessDataFormat(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r10.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r10[r3]
            android.util.Pair r1 = guessDataFormat(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r6
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = r6
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r10.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r10 = r10.split(r0, r6)
            int r0 = r10.length
            if (r0 != r4) goto L_0x00ff
            r0 = r10[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r10 = r10[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r4 = 10
            if (r10 < 0) goto L_0x00f5
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r0 = 5
            if (r10 > 0) goto L_0x00eb
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r10.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
            return r10
        L_0x00eb:
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r10
        L_0x00f5:
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r10
        L_0x00ff:
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x013c }
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r3 = 4
            if (r2 < 0) goto L_0x0124
            r8 = 65535(0xffff, double:3.23786E-319)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x0124
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x0124:
            if (r2 >= 0) goto L_0x0132
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x0132:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x013c:
            java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x014b }
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014b }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014b }
            r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x014b }
            return r10
        L_0x014b:
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.guessDataFormat(java.lang.String):android.util.Pair");
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (this.mMimeType == 7) {
                intValue += this.mOrfMakerNoteOffset;
            }
            if (intValue > 0 && intValue2 > 0) {
                this.mHasThumbnail = true;
                if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                    byte[] bArr = new byte[intValue2];
                    byteOrderedDataInputStream.skipFully(intValue);
                    byteOrderedDataInputStream.readFully(bArr);
                    this.mThumbnailBytes = bArr;
                }
                this.mThumbnailOffset = intValue;
                this.mThumbnailLength = intValue2;
            }
            if (DEBUG) {
                Log.d(TAG, "Setting thumbnail attributes with offset: " + intValue + ", length: " + intValue2);
            }
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        byte[] bArr;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = byteOrderedDataInputStream;
        HashMap hashMap2 = hashMap;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap2.get(TAG_STRIP_OFFSETS);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap2.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] convertToLongArray = ExifInterfaceUtils.convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
            long[] convertToLongArray2 = ExifInterfaceUtils.convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
            if (convertToLongArray == null || convertToLongArray.length == 0) {
                Log.w(TAG, "stripOffsets should not be null or have zero length.");
            } else if (convertToLongArray2 == null || convertToLongArray2.length == 0) {
                Log.w(TAG, "stripByteCounts should not be null or have zero length.");
            } else if (convertToLongArray.length != convertToLongArray2.length) {
                Log.w(TAG, "stripOffsets and stripByteCounts should have same length.");
            } else {
                long j = 0;
                for (long j2 : convertToLongArray2) {
                    j += j2;
                }
                int i = (int) j;
                byte[] bArr2 = new byte[i];
                this.mAreThumbnailStripsConsecutive = true;
                this.mHasThumbnailStrips = true;
                this.mHasThumbnail = true;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i2 < convertToLongArray.length) {
                    int i5 = (int) convertToLongArray[i2];
                    int i6 = (int) convertToLongArray2[i2];
                    if (i2 < convertToLongArray.length - 1) {
                        bArr = bArr2;
                        if (((long) (i5 + i6)) != convertToLongArray[i2 + 1]) {
                            this.mAreThumbnailStripsConsecutive = false;
                        }
                    } else {
                        bArr = bArr2;
                    }
                    int i7 = i5 - i3;
                    if (i7 < 0) {
                        Log.d(TAG, "Invalid strip offset value");
                        return;
                    }
                    try {
                        byteOrderedDataInputStream2.skipFully(i7);
                        int i8 = i3 + i7;
                        byte[] bArr3 = new byte[i6];
                        try {
                            byteOrderedDataInputStream2.readFully(bArr3);
                            i3 = i8 + i6;
                            byte[] bArr4 = bArr;
                            System.arraycopy(bArr3, 0, bArr4, i4, i6);
                            i4 += i6;
                            i2++;
                            bArr2 = bArr4;
                        } catch (EOFException unused) {
                            Log.d(TAG, "Failed to read " + i6 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d(TAG, "Failed to skip " + i7 + " bytes.");
                        return;
                    }
                }
                this.mThumbnailBytes = bArr2;
                if (this.mAreThumbnailStripsConsecutive) {
                    this.mThumbnailOffset = (int) convertToLongArray[0];
                    this.mThumbnailLength = i;
                }
            }
        }
    }

    private void initForFilename(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (isSeekableFD(fileInputStream2.getFD())) {
                        this.mSeekableFileDescriptor = fileInputStream2.getFD();
                    } else {
                        this.mSeekableFileDescriptor = null;
                    }
                    loadAttributes(fileInputStream2);
                    ExifInterfaceUtils.closeQuietly(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    ExifInterfaceUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                ExifInterfaceUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    private static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = IDENTIFIER_EXIF_APP1;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0090 A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isHeifFormat(byte[] r14) throws java.io.IOException {
        /*
            r13 = this;
            r13 = 0
            r0 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r1 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x008b }
            r1.<init>((byte[]) r14)     // Catch:{ Exception -> 0x008b }
            int r0 = r1.readInt()     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r2 = (long) r0     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r0 = 4
            byte[] r4 = new byte[r0]     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r1.readFully(r4)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            byte[] r5 = HEIF_TYPE_FTYP     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r4 = java.util.Arrays.equals(r4, r5)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r4 != 0) goto L_0x001e
            r1.close()
            return r13
        L_0x001e:
            r4 = 1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r7 = 8
            if (r6 != 0) goto L_0x003b
            long r2 = r1.readLong()     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r9 = 16
            int r6 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x003c
            r1.close()
            return r13
        L_0x0034:
            r13 = move-exception
            r0 = r1
            goto L_0x009d
        L_0x0038:
            r14 = move-exception
            r0 = r1
            goto L_0x008c
        L_0x003b:
            r9 = r7
        L_0x003c:
            int r6 = r14.length     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r11 = (long) r6     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            int r6 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x0044
            int r14 = r14.length     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r2 = (long) r14
        L_0x0044:
            long r2 = r2 - r9
            int r14 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r14 >= 0) goto L_0x004d
            r1.close()
            return r13
        L_0x004d:
            byte[] r14 = new byte[r0]     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r6 = 0
            r0 = r13
            r8 = r0
        L_0x0053:
            r9 = 4
            long r9 = r2 / r9
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x0085
            r1.readFully(r14)     // Catch:{ EOFException -> 0x0081 }
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r9 = HEIF_BRAND_MIF1     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r9 = java.util.Arrays.equals(r14, r9)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r10 = 1
            if (r9 == 0) goto L_0x006e
            r0 = r10
            goto L_0x0077
        L_0x006e:
            byte[] r9 = HEIF_BRAND_HEIC     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r9 = java.util.Arrays.equals(r14, r9)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r9 == 0) goto L_0x0077
            r8 = r10
        L_0x0077:
            if (r0 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            r1.close()
            return r10
        L_0x007f:
            long r6 = r6 + r4
            goto L_0x0053
        L_0x0081:
            r1.close()
            return r13
        L_0x0085:
            r1.close()
            goto L_0x009c
        L_0x0089:
            r13 = move-exception
            goto L_0x009d
        L_0x008b:
            r14 = move-exception
        L_0x008c:
            boolean r1 = DEBUG     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0097
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Exception parsing HEIF file type box."
            android.util.Log.d(r1, r2, r14)     // Catch:{ all -> 0x0089 }
        L_0x0097:
            if (r0 == 0) goto L_0x009c
            r0.close()
        L_0x009c:
            return r13
        L_0x009d:
            if (r0 == 0) goto L_0x00a2
            r0.close()
        L_0x00a2:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isHeifFormat(byte[]):boolean");
    }

    private static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isOrfFormat(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.setByteOrder(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r3 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r4 = 20306(0x4f52, float:2.8455E-41)
            if (r3 == r4) goto L_0x001c
            r4 = 21330(0x5352, float:2.989E-41)
            if (r3 != r4) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r3 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002d
        L_0x0026:
            r3 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r3
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isOrfFormat(byte[]):boolean");
    }

    private boolean isPngFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isRw2Format(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.setByteOrder(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r3 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r4 = 85
            if (r3 != r4) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r3 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x0029
        L_0x0022:
            r3 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r3
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isRw2Format(byte[]):boolean");
    }

    private static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        try {
            ExifInterfaceUtils.Api21Impl.lseek(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!DEBUG) {
                return false;
            }
            Log.d(TAG, "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        int intValue;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
            int[] iArr2 = BITS_PER_SAMPLE_RGB;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.mMimeType == 3 && (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((intValue = exifAttribute.getIntValue(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "Unsupported data type value");
        return false;
    }

    private static boolean isSupportedFormatForSavingAttributes(int i) {
        return i == 4 || i == 13 || i == 14;
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.hashCode();
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -1875291391:
                    if (lowerCase.equals("image/x-fuji-raf")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1635437028:
                    if (lowerCase.equals("image/x-samsung-srw")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1594371159:
                    if (lowerCase.equals("image/x-sony-arw")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1487464693:
                    if (lowerCase.equals("image/heic")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1487464690:
                    if (lowerCase.equals("image/heif")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1487394660:
                    if (lowerCase.equals("image/jpeg")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1487018032:
                    if (lowerCase.equals("image/webp")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1423313290:
                    if (lowerCase.equals("image/x-adobe-dng")) {
                        c = 7;
                        break;
                    }
                    break;
                case -985160897:
                    if (lowerCase.equals("image/x-panasonic-rw2")) {
                        c = 8;
                        break;
                    }
                    break;
                case -879258763:
                    if (lowerCase.equals("image/png")) {
                        c = 9;
                        break;
                    }
                    break;
                case -332763809:
                    if (lowerCase.equals("image/x-pentax-pef")) {
                        c = 10;
                        break;
                    }
                    break;
                case 1378106698:
                    if (lowerCase.equals("image/x-olympus-orf")) {
                        c = 11;
                        break;
                    }
                    break;
                case 2099152104:
                    if (lowerCase.equals("image/x-nikon-nef")) {
                        c = 12;
                        break;
                    }
                    break;
                case 2099152524:
                    if (lowerCase.equals("image/x-nikon-nrw")) {
                        c = 13;
                        break;
                    }
                    break;
                case 2111234748:
                    if (lowerCase.equals("image/x-canon-cr2")) {
                        c = 14;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new NullPointerException("mimeType shouldn't be null");
        }
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    private boolean isWebpFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else if (bArr[i] != bArr2[i]) {
                return false;
            } else {
                i++;
            }
        }
    }

    private void loadAttributes(@NonNull InputStream inputStream) {
        if (inputStream != null) {
            int i = 0;
            while (i < EXIF_TAGS.length) {
                try {
                    this.mAttributes[i] = new HashMap<>();
                    i++;
                } catch (IOException | UnsupportedOperationException e) {
                    boolean z = DEBUG;
                    if (z) {
                        Log.w(TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                    }
                    addDefaultValuesForCompatibility();
                    if (!z) {
                        return;
                    }
                } catch (Throwable th) {
                    addDefaultValuesForCompatibility();
                    if (DEBUG) {
                        printAttributes();
                    }
                    throw th;
                }
            }
            if (!this.mIsExifDataOnly) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.mMimeType = getMimeType(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (shouldSupportSeek(this.mMimeType)) {
                SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(inputStream);
                if (this.mIsExifDataOnly) {
                    getStandaloneAttributes(seekableByteOrderedDataInputStream);
                } else {
                    int i2 = this.mMimeType;
                    if (i2 == 12) {
                        getHeifAttributes(seekableByteOrderedDataInputStream);
                    } else if (i2 == 7) {
                        getOrfAttributes(seekableByteOrderedDataInputStream);
                    } else if (i2 == 10) {
                        getRw2Attributes(seekableByteOrderedDataInputStream);
                    } else {
                        getRawAttributes(seekableByteOrderedDataInputStream);
                    }
                }
                seekableByteOrderedDataInputStream.seek((long) this.mOffsetToExifData);
                setThumbnailData(seekableByteOrderedDataInputStream);
            } else {
                ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
                int i3 = this.mMimeType;
                if (i3 == 4) {
                    getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                } else if (i3 == 13) {
                    getPngAttributes(byteOrderedDataInputStream);
                } else if (i3 == 9) {
                    getRafAttributes(byteOrderedDataInputStream);
                } else if (i3 == 14) {
                    getWebpAttributes(byteOrderedDataInputStream);
                }
            }
            addDefaultValuesForCompatibility();
            if (!DEBUG) {
                return;
            }
            printAttributes();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (com.meizu.common.util.LunarCalendar.DATE_SEPARATOR.equals(r1) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Long parseDateTime(@androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.lang.String r11, @androidx.annotation.Nullable java.lang.String r12) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x0084
            java.util.regex.Pattern r1 = NON_ZERO_TIME_PATTERN
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x0011
            goto L_0x0084
        L_0x0011:
            java.text.ParsePosition r1 = new java.text.ParsePosition
            r2 = 0
            r1.<init>(r2)
            java.text.SimpleDateFormat r3 = sFormatterPrimary     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r3 != 0) goto L_0x0028
            java.text.SimpleDateFormat r3 = sFormatterSecondary     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r3 != 0) goto L_0x0028
            return r0
        L_0x0028:
            long r3 = r3.getTime()     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0078
            r10 = 1
            java.lang.String r1 = r12.substring(r2, r10)     // Catch:{ IllegalArgumentException -> 0x0084 }
            r2 = 3
            java.lang.String r5 = r12.substring(r10, r2)     // Catch:{ IllegalArgumentException -> 0x0084 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x0084 }
            r6 = 6
            r7 = 4
            java.lang.String r6 = r12.substring(r7, r6)     // Catch:{ IllegalArgumentException -> 0x0084 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.lang.String r8 = "+"
            boolean r8 = r8.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.lang.String r9 = "-"
            if (r8 != 0) goto L_0x0056
            boolean r8 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r8 == 0) goto L_0x0078
        L_0x0056:
            java.lang.String r8 = ":"
            java.lang.String r12 = r12.substring(r2, r7)     // Catch:{ IllegalArgumentException -> 0x0084 }
            boolean r12 = r8.equals(r12)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0078
            r12 = 14
            if (r5 > r12) goto L_0x0078
            int r5 = r5 * 60
            int r5 = r5 + r6
            r12 = 60000(0xea60, float:8.4078E-41)
            int r5 = r5 * r12
            boolean r12 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r10 = -1
        L_0x0075:
            int r5 = r5 * r10
            long r1 = (long) r5     // Catch:{ IllegalArgumentException -> 0x0084 }
            long r3 = r3 + r1
        L_0x0078:
            if (r11 == 0) goto L_0x007f
            long r10 = androidx.exifinterface.media.ExifInterfaceUtils.parseSubSeconds(r11)     // Catch:{ IllegalArgumentException -> 0x0084 }
            long r3 = r3 + r10
        L_0x007f:
            java.lang.Long r10 = java.lang.Long.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0084 }
            return r10
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.parseDateTime(java.lang.String, java.lang.String, java.lang.String):java.lang.Long");
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i = this.mMimeType;
        if (i == 7 || i == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt >= 8) {
                int i2 = readInt - 8;
                if (i2 > 0) {
                    byteOrderedDataInputStream.skipFully(i2);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void printAttributes() {
        for (int i = 0; i < this.mAttributes.length; i++) {
            Log.d(TAG, "The size of tag group[" + i + "]: " + this.mAttributes[i].size());
            for (Map.Entry next : this.mAttributes[i].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                Log.d(TAG, "tagName: " + ((String) next.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.getStringValue(this.mExifByteOrder) + "'");
            }
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            if (DEBUG) {
                Log.d(TAG, "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (DEBUG) {
                Log.d(TAG, "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void readExifSegment(byte[] bArr, int i) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0280  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r26, int r27) throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r4 = r26.position()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            short r3 = r26.readShort()
            boolean r4 = DEBUG
            java.lang.String r5 = "ExifInterface"
            if (r4 == 0) goto L_0x0031
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "numberOfDirectoryEntry: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r5, r4)
        L_0x0031:
            if (r3 > 0) goto L_0x0034
            return
        L_0x0034:
            r6 = 0
        L_0x0035:
            if (r6 >= r3) goto L_0x0341
            int r10 = r26.readUnsignedShort()
            int r11 = r26.readUnsignedShort()
            int r14 = r26.readInt()
            int r12 = r26.position()
            long r12 = (long) r12
            r15 = 4
            long r12 = r12 + r15
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$ExifTag>[] r17 = sExifTagMapsForReading
            r4 = r17[r2]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)
            java.lang.Object r4 = r4.get(r9)
            androidx.exifinterface.media.ExifInterface$ExifTag r4 = (androidx.exifinterface.media.ExifInterface.ExifTag) r4
            boolean r9 = DEBUG
            if (r9 == 0) goto L_0x0086
            java.lang.Integer r15 = java.lang.Integer.valueOf(r27)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            if (r4 == 0) goto L_0x006c
            java.lang.String r8 = r4.name
        L_0x0069:
            r20 = r3
            goto L_0x006e
        L_0x006c:
            r8 = 0
            goto L_0x0069
        L_0x006e:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            r21 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            java.lang.Object[] r3 = new java.lang.Object[]{r15, r7, r8, r3, r6}
            java.lang.String r6 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            android.util.Log.d(r5, r3)
            goto L_0x008a
        L_0x0086:
            r20 = r3
            r21 = r6
        L_0x008a:
            r3 = 7
            if (r4 != 0) goto L_0x00a7
            if (r9 == 0) goto L_0x00a3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since tag number is not defined: "
            r6.append(r7)
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
        L_0x00a3:
            r22 = r4
            goto L_0x0125
        L_0x00a7:
            if (r11 <= 0) goto L_0x00ae
            int[] r6 = IFD_FORMAT_BYTES_PER_FORMAT
            int r7 = r6.length
            if (r11 < r7) goto L_0x00b1
        L_0x00ae:
            r22 = r4
            goto L_0x010f
        L_0x00b1:
            boolean r7 = r4.isFormatCompatible(r11)
            if (r7 != 0) goto L_0x00dc
            if (r9 == 0) goto L_0x00a3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since data format ("
            r6.append(r7)
            java.lang.String[] r7 = IFD_FORMAT_NAMES
            r7 = r7[r11]
            r6.append(r7)
            java.lang.String r7 = ") is unexpected for tag: "
            r6.append(r7)
            java.lang.String r7 = r4.name
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
            goto L_0x00a3
        L_0x00dc:
            if (r11 != r3) goto L_0x00e0
            int r11 = r4.primaryFormat
        L_0x00e0:
            long r7 = (long) r14
            r6 = r6[r11]
            r22 = r4
            long r3 = (long) r6
            long r3 = r3 * r7
            r6 = 0
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x00f7
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r6 = 1
            goto L_0x0128
        L_0x00f7:
            if (r9 == 0) goto L_0x010d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since the number of components is invalid: "
            r6.append(r7)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
        L_0x010d:
            r6 = 0
            goto L_0x0128
        L_0x010f:
            if (r9 == 0) goto L_0x0125
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Skip the tag entry since data format is invalid: "
            r3.append(r4)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r5, r3)
        L_0x0125:
            r3 = 0
            goto L_0x010d
        L_0x0128:
            if (r6 != 0) goto L_0x012f
            r1.seek(r12)
            goto L_0x0338
        L_0x012f:
            r6 = 4
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            java.lang.String r7 = "Compression"
            if (r6 <= 0) goto L_0x01bb
            int r6 = r26.readInt()
            if (r9 == 0) goto L_0x0151
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r15 = "seek to data offset: "
            r8.append(r15)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r5, r8)
        L_0x0151:
            int r8 = r0.mMimeType
            r15 = 7
            if (r8 != r15) goto L_0x01b0
            r8 = r22
            java.lang.String r15 = r8.name
            r18 = r12
            java.lang.String r12 = "MakerNote"
            boolean r12 = r12.equals(r15)
            if (r12 == 0) goto L_0x0169
            r0.mOrfMakerNoteOffset = r6
        L_0x0166:
            r16 = r14
            goto L_0x01b6
        L_0x0169:
            r12 = 6
            if (r2 != r12) goto L_0x0166
            java.lang.String r13 = "ThumbnailImage"
            java.lang.String r15 = r8.name
            boolean r13 = r13.equals(r15)
            if (r13 == 0) goto L_0x0166
            r0.mOrfThumbnailOffset = r6
            r0.mOrfThumbnailLength = r14
            java.nio.ByteOrder r13 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r12 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r12, (java.nio.ByteOrder) r13)
            int r13 = r0.mOrfThumbnailOffset
            r15 = r14
            long r13 = (long) r13
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r13, (java.nio.ByteOrder) r2)
            int r13 = r0.mOrfThumbnailLength
            long r13 = (long) r13
            r16 = r15
            java.nio.ByteOrder r15 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r13 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r13, (java.nio.ByteOrder) r15)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r14 = r0.mAttributes
            r15 = 4
            r14 = r14[r15]
            r14.put(r7, r12)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r12 = r0.mAttributes
            r12 = r12[r15]
            java.lang.String r14 = "JPEGInterchangeFormat"
            r12.put(r14, r2)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r15]
            java.lang.String r12 = "JPEGInterchangeFormatLength"
            r2.put(r12, r13)
            goto L_0x01b6
        L_0x01b0:
            r18 = r12
            r16 = r14
            r8 = r22
        L_0x01b6:
            long r12 = (long) r6
            r1.seek(r12)
            goto L_0x01c1
        L_0x01bb:
            r18 = r12
            r16 = r14
            r8 = r22
        L_0x01c1:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = sExifPointerTagMap
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            java.lang.Object r2 = r2.get(r6)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r9 == 0) goto L_0x01eb
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = "nextIfdType: "
            r6.append(r10)
            r6.append(r2)
            java.lang.String r10 = " byteCount: "
            r6.append(r10)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
        L_0x01eb:
            r6 = 8
            r10 = 3
            if (r2 == 0) goto L_0x02bd
            if (r11 == r10) goto L_0x0212
            r3 = 4
            if (r11 == r3) goto L_0x020d
            if (r11 == r6) goto L_0x0208
            r3 = 9
            if (r11 == r3) goto L_0x0202
            r3 = 13
            if (r11 == r3) goto L_0x0202
            r3 = -1
            goto L_0x0217
        L_0x0202:
            int r3 = r26.readInt()
        L_0x0206:
            long r3 = (long) r3
            goto L_0x0217
        L_0x0208:
            short r3 = r26.readShort()
            goto L_0x0206
        L_0x020d:
            long r3 = r26.readUnsignedInt()
            goto L_0x0217
        L_0x0212:
            int r3 = r26.readUnsignedShort()
            goto L_0x0206
        L_0x0217:
            if (r9 == 0) goto L_0x022c
            java.lang.Long r6 = java.lang.Long.valueOf(r3)
            java.lang.String r7 = r8.name
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7}
            java.lang.String r7 = "Offset: %d, tagName: %s"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            android.util.Log.d(r5, r6)
        L_0x022c:
            r6 = 0
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            java.lang.String r7 = ")"
            r8 = -1
            if (r6 <= 0) goto L_0x0280
            int r6 = r26.length()
            if (r6 == r8) goto L_0x0244
            int r6 = r26.length()
            long r10 = (long) r6
            int r6 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x0280
        L_0x0244:
            java.util.Set<java.lang.Integer> r6 = r0.mAttributesOffsets
            int r8 = (int) r3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r6 = r6.contains(r8)
            if (r6 != 0) goto L_0x025e
            r1.seek(r3)
            int r2 = r2.intValue()
            r0.readImageFileDirectory(r1, r2)
        L_0x025b:
            r12 = r18
            goto L_0x02b8
        L_0x025e:
            if (r9 == 0) goto L_0x025b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Skip jump into the IFD since it has already been read: IfdType "
            r6.append(r8)
            r6.append(r2)
            java.lang.String r2 = " (at "
            r6.append(r2)
            r6.append(r3)
            r6.append(r7)
            java.lang.String r2 = r6.toString()
            android.util.Log.d(r5, r2)
            goto L_0x025b
        L_0x0280:
            if (r9 == 0) goto L_0x025b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r6)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r26.length()
            if (r3 == r8) goto L_0x02b4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " (total length: "
            r3.append(r2)
            int r2 = r26.length()
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = r3.toString()
        L_0x02b4:
            android.util.Log.d(r5, r2)
            goto L_0x025b
        L_0x02b8:
            r1.seek(r12)
            goto L_0x0338
        L_0x02bd:
            r12 = r18
            int r2 = r26.position()
            int r9 = r0.mOffsetToExifData
            int r2 = r2 + r9
            int r3 = (int) r3
            byte[] r3 = new byte[r3]
            r1.readFully(r3)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            long r14 = (long) r2
            r23 = r12
            r12 = r4
            r13 = r11
            r18 = r14
            r14 = r16
            r15 = r18
            r17 = r3
            r12.<init>(r13, r14, r15, r17)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r27]
            java.lang.String r3 = r8.name
            r2.put(r3, r4)
            java.lang.String r2 = "DNGVersion"
            java.lang.String r3 = r8.name
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x02f3
            r0.mMimeType = r10
        L_0x02f3:
            java.lang.String r2 = "Make"
            java.lang.String r3 = r8.name
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0307
            java.lang.String r2 = "Model"
            java.lang.String r3 = r8.name
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0315
        L_0x0307:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            java.lang.String r2 = r4.getStringValue(r2)
            java.lang.String r3 = "PENTAX"
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L_0x0328
        L_0x0315:
            java.lang.String r2 = r8.name
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x032a
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            int r2 = r4.getIntValue(r2)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r3) goto L_0x032a
        L_0x0328:
            r0.mMimeType = r6
        L_0x032a:
            int r2 = r26.position()
            long r2 = (long) r2
            r12 = r23
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x0338
            r1.seek(r12)
        L_0x0338:
            int r6 = r21 + 1
            short r6 = (short) r6
            r2 = r27
            r3 = r20
            goto L_0x0035
        L_0x0341:
            int r2 = r26.readInt()
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x035a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r6 = "nextIfdOffset: %d"
            java.lang.String r4 = java.lang.String.format(r6, r4)
            android.util.Log.d(r5, r4)
        L_0x035a:
            long r6 = (long) r2
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x03a5
            java.util.Set<java.lang.Integer> r4 = r0.mAttributesOffsets
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            boolean r4 = r4.contains(r8)
            if (r4 != 0) goto L_0x038e
            r1.seek(r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x037f
            r0.readImageFileDirectory(r1, r3)
            goto L_0x03bb
        L_0x037f:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03bb
            r0.readImageFileDirectory(r1, r3)
            goto L_0x03bb
        L_0x038e:
            if (r3 == 0) goto L_0x03bb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
            goto L_0x03bb
        L_0x03a5:
            if (r3 == 0) goto L_0x03bb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
        L_0x03bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.readImageFileDirectory(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream, int):void");
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            this.mAttributes[i].remove(str);
        }
    }

    private void replaceInvalidTags(int i, String str, String str2) {
        if (!this.mAttributes[i].isEmpty() && this.mAttributes[i].get(str) != null) {
            HashMap<String, ExifAttribute> hashMap = this.mAttributes[i];
            hashMap.put(str2, hashMap.get(str));
            this.mAttributes[i].remove(str);
        }
    }

    private void retrieveJpegImageSize(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT);
            ExifAttribute exifAttribute4 = this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute3.getIntValue(this.mExifByteOrder);
                seekableByteOrderedDataInputStream.seek((long) intValue);
                byte[] bArr = new byte[intValue2];
                seekableByteOrderedDataInputStream.readFully(bArr);
                getJpegAttributes(new ByteOrderedDataInputStream(bArr), intValue, i);
            }
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (byteOrderedDataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.writeByte(-1);
            if (byteOrderedDataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.writeByte(-40);
                ExifAttribute remove = (getAttribute(TAG_XMP) == null || !this.mXmpIsFromSeparateMarker) ? null : this.mAttributes[0].remove(TAG_XMP);
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(-31);
                writeExifSegment(byteOrderedDataOutputStream);
                if (remove != null) {
                    this.mAttributes[0].put(TAG_XMP, remove);
                }
                byte[] bArr = new byte[4096];
                while (byteOrderedDataInputStream.readByte() == -1) {
                    byte readByte = byteOrderedDataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream);
                        return;
                    } else if (readByte != -31) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                        byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                        int i = readUnsignedShort - 2;
                        if (i >= 0) {
                            while (i > 0) {
                                int read = byteOrderedDataInputStream.read(bArr, 0, Math.min(i, 4096));
                                if (read < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read);
                                i -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                        int i2 = readUnsignedShort2 - 2;
                        if (i2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (i2 >= 6) {
                                byteOrderedDataInputStream.readFully(bArr2);
                                if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                    byteOrderedDataInputStream.skipFully(readUnsignedShort2 - 8);
                                }
                            }
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2);
                            if (i2 >= 6) {
                                i2 = readUnsignedShort2 - 8;
                                byteOrderedDataOutputStream.write(bArr2);
                            }
                            while (i2 > 0) {
                                int read2 = byteOrderedDataInputStream.read(bArr, 0, Math.min(i2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read2);
                                i2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void savePngAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = PNG_SIGNATURE;
        ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        int i = this.mOffsetToExifData;
        if (i == 0) {
            int readInt = byteOrderedDataInputStream.readInt();
            byteOrderedDataOutputStream.writeInt(readInt);
            ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt + 8);
        } else {
            ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, (i - bArr.length) - 8);
            byteOrderedDataInputStream.skipFully(byteOrderedDataInputStream.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                writeExifSegment(byteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.mOutputStream).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
                ExifInterfaceUtils.closeQuietly(byteArrayOutputStream2);
                ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
            throw th;
        }
    }

    private void saveWebpAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i;
        int i2;
        int i3;
        boolean z;
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        if (DEBUG) {
            Log.d(TAG, "saveWebpAttributes starting with (inputStream: " + inputStream2 + ", outputStream: " + outputStream2 + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream2, byteOrder);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream2, byteOrder);
        byte[] bArr = WEBP_SIGNATURE_1;
        ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        byte[] bArr2 = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                int i4 = this.mOffsetToExifData;
                if (i4 != 0) {
                    ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2, (i4 - ((bArr.length + 4) + bArr2.length)) - 8);
                    byteOrderedDataInputStream.skipFully(4);
                    int readInt = byteOrderedDataInputStream.readInt();
                    if (readInt % 2 != 0) {
                        readInt++;
                    }
                    byteOrderedDataInputStream.skipFully(readInt);
                    writeExifSegment(byteOrderedDataOutputStream2);
                } else {
                    byte[] bArr3 = new byte[4];
                    byteOrderedDataInputStream.readFully(bArr3);
                    byte[] bArr4 = WEBP_CHUNK_TYPE_VP8X;
                    boolean z2 = false;
                    boolean z3 = true;
                    if (Arrays.equals(bArr3, bArr4)) {
                        int readInt2 = byteOrderedDataInputStream.readInt();
                        byte[] bArr5 = new byte[(readInt2 % 2 == 1 ? readInt2 + 1 : readInt2)];
                        byteOrderedDataInputStream.readFully(bArr5);
                        byte b = (byte) (8 | bArr5[0]);
                        bArr5[0] = b;
                        if (((b >> 1) & 1) == 1) {
                            z2 = true;
                        }
                        byteOrderedDataOutputStream2.write(bArr4);
                        byteOrderedDataOutputStream2.writeInt(readInt2);
                        byteOrderedDataOutputStream2.write(bArr5);
                        if (z2) {
                            copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_ANIM, (byte[]) null);
                            while (true) {
                                byte[] bArr6 = new byte[4];
                                try {
                                    byteOrderedDataInputStream.readFully(bArr6);
                                    z = !Arrays.equals(bArr6, WEBP_CHUNK_TYPE_ANMF);
                                } catch (EOFException unused) {
                                    z = true;
                                }
                                if (z) {
                                    break;
                                }
                                copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr6);
                            }
                            writeExifSegment(byteOrderedDataOutputStream2);
                        } else {
                            copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);
                            writeExifSegment(byteOrderedDataOutputStream2);
                        }
                    } else {
                        byte[] bArr7 = WEBP_CHUNK_TYPE_VP8;
                        if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                            int readInt3 = byteOrderedDataInputStream.readInt();
                            int i5 = readInt3 % 2 == 1 ? readInt3 + 1 : readInt3;
                            byte[] bArr8 = new byte[3];
                            if (Arrays.equals(bArr3, bArr7)) {
                                byteOrderedDataInputStream.readFully(bArr8);
                                byte[] bArr9 = new byte[3];
                                byteOrderedDataInputStream.readFully(bArr9);
                                if (Arrays.equals(WEBP_VP8_SIGNATURE, bArr9)) {
                                    int readInt4 = byteOrderedDataInputStream.readInt();
                                    i = (readInt4 << 2) >> 18;
                                    i5 -= 10;
                                    i3 = (readInt4 << 18) >> 18;
                                    i2 = readInt4;
                                    z3 = false;
                                } else {
                                    throw new IOException("Error checking VP8 signature");
                                }
                            } else if (!Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                i3 = 0;
                                z3 = false;
                                i2 = 0;
                                i = 0;
                            } else if (byteOrderedDataInputStream.readByte() == 47) {
                                i2 = byteOrderedDataInputStream.readInt();
                                i3 = (i2 & 16383) + 1;
                                i = ((i2 & 268419072) >>> 14) + 1;
                                if ((i2 & CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED) == 0) {
                                    z3 = false;
                                }
                                i5 -= 5;
                            } else {
                                throw new IOException("Error checking VP8L signature");
                            }
                            byteOrderedDataOutputStream2.write(bArr4);
                            byteOrderedDataOutputStream2.writeInt(10);
                            byte[] bArr10 = new byte[10];
                            if (z3) {
                                bArr10[0] = (byte) (bArr10[0] | 16);
                            }
                            bArr10[0] = (byte) (bArr10[0] | 8);
                            int i6 = i3 - 1;
                            int i7 = i - 1;
                            bArr10[4] = (byte) i6;
                            bArr10[5] = (byte) (i6 >> 8);
                            bArr10[6] = (byte) (i6 >> 16);
                            bArr10[7] = (byte) i7;
                            bArr10[8] = (byte) (i7 >> 8);
                            bArr10[9] = (byte) (i7 >> 16);
                            byteOrderedDataOutputStream2.write(bArr10);
                            byteOrderedDataOutputStream2.write(bArr3);
                            byteOrderedDataOutputStream2.writeInt(readInt3);
                            if (Arrays.equals(bArr3, bArr7)) {
                                byteOrderedDataOutputStream2.write(bArr8);
                                byteOrderedDataOutputStream2.write(WEBP_VP8_SIGNATURE);
                                byteOrderedDataOutputStream2.writeInt(i2);
                            } else if (Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                byteOrderedDataOutputStream2.write(47);
                                byteOrderedDataOutputStream2.writeInt(i2);
                            }
                            ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2, i5);
                            writeExifSegment(byteOrderedDataOutputStream2);
                        }
                    }
                }
                ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
                int size = byteArrayOutputStream2.size();
                byte[] bArr11 = WEBP_SIGNATURE_2;
                byteOrderedDataOutputStream.writeInt(size + bArr11.length);
                byteOrderedDataOutputStream.write(bArr11);
                byteArrayOutputStream2.writeTo(byteOrderedDataOutputStream);
                ExifInterfaceUtils.closeQuietly(byteArrayOutputStream2);
            } catch (Exception e) {
                e = e;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            throw new IOException("Failed to save WebP file", e);
        }
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue == 6) {
                    handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                    return;
                } else if (intValue != 7) {
                    return;
                }
            }
            if (isSupportedDataType(hashMap)) {
                handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
    }

    private static boolean shouldSupportSeek(int i) {
        return (i == 4 || i == 9 || i == 13 || i == 14) ? false : true;
    }

    private void swapBasedOnImageSize(int i, int i2) throws IOException {
        if (!this.mAttributes[i].isEmpty() && !this.mAttributes[i2].isEmpty()) {
            ExifAttribute exifAttribute = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
            ExifAttribute exifAttribute3 = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute4 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
            if (exifAttribute == null || exifAttribute2 == null) {
                if (DEBUG) {
                    Log.d(TAG, "First image does not contain valid size information");
                }
            } else if (exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                if (intValue < intValue3 && intValue2 < intValue4) {
                    HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i2];
                    hashMapArr[i2] = hashMap;
                }
            } else if (DEBUG) {
                Log.d(TAG, "Second image does not contain valid size information");
            }
        } else if (DEBUG) {
            Log.d(TAG, "Cannot perform swap since only one image data exists");
        }
    }

    private void updateImageSizeValues(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3 = this.mAttributes[i].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute4 = this.mAttributes[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute5 = this.mAttributes[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute6 = this.mAttributes[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute7 = this.mAttributes[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute3 != null) {
            if (exifAttribute3.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
            } else {
                int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
            }
            this.mAttributes[i].put(TAG_IMAGE_WIDTH, exifAttribute2);
            this.mAttributes[i].put(TAG_IMAGE_LENGTH, exifAttribute);
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            retrieveJpegImageSize(seekableByteOrderedDataInputStream, i);
        } else {
            int intValue = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute6.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute7.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute5.getIntValue(this.mExifByteOrder);
            if (intValue2 > intValue && intValue3 > intValue4) {
                ExifAttribute createUShort = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[i].put(TAG_IMAGE_WIDTH, createUShort2);
            }
        }
    }

    private void validateImages() throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
        }
        replaceInvalidTags(0, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(4, TAG_ORIENTATION, TAG_THUMBNAIL_ORIENTATION);
        replaceInvalidTags(4, TAG_IMAGE_LENGTH, TAG_THUMBNAIL_IMAGE_LENGTH);
        replaceInvalidTags(4, TAG_IMAGE_WIDTH, TAG_THUMBNAIL_IMAGE_WIDTH);
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = byteOrderedDataOutputStream;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                removeAttribute(TAG_STRIP_OFFSETS);
                removeAttribute(TAG_STRIP_BYTE_COUNTS);
            } else {
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT);
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            }
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            for (Object obj : this.mAttributes[i].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifAttribute.createUShort(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_STRIP_BYTE_COUNTS, ExifAttribute.createUShort(this.mThumbnailLength, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifAttribute.createULong(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifAttribute.createULong((long) this.mThumbnailLength, this.mExifByteOrder));
            }
        }
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            int i3 = 0;
            for (Map.Entry<String, ExifAttribute> value : this.mAttributes[i2].entrySet()) {
                int size = ((ExifAttribute) value.getValue()).size();
                if (size > 4) {
                    i3 += size;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int i4 = 8;
        for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
            if (!this.mAttributes[i5].isEmpty()) {
                iArr[i5] = i4;
                i4 += (this.mAttributes[i5].size() * 12) + 6 + iArr2[i5];
            }
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifAttribute.createUShort(i4, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifAttribute.createULong((long) i4, this.mExifByteOrder));
            }
            this.mThumbnailOffset = i4;
            i4 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            i4 += 8;
        }
        if (DEBUG) {
            for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
                Log.d(TAG, String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i6), Integer.valueOf(iArr[i6]), Integer.valueOf(this.mAttributes[i6].size()), Integer.valueOf(iArr2[i6]), Integer.valueOf(i4)}));
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long) iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long) iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long) iArr[3], this.mExifByteOrder));
        }
        int i7 = this.mMimeType;
        if (i7 != 4) {
            if (i7 == 13) {
                byteOrderedDataOutputStream2.writeInt(i4);
                byteOrderedDataOutputStream2.write(PNG_CHUNK_TYPE_EXIF);
            } else if (i7 == 14) {
                byteOrderedDataOutputStream2.write(WEBP_CHUNK_TYPE_EXIF);
                byteOrderedDataOutputStream2.writeInt(i4);
            }
        } else if (i4 <= 65535) {
            byteOrderedDataOutputStream2.writeUnsignedShort(i4);
            byteOrderedDataOutputStream2.write(IDENTIFIER_EXIF_APP1);
        } else {
            throw new IllegalStateException("Size of exif data (" + i4 + " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)");
        }
        byteOrderedDataOutputStream2.writeShort(this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
        byteOrderedDataOutputStream2.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream2.writeUnsignedShort(42);
        byteOrderedDataOutputStream2.writeUnsignedInt(8);
        for (int i8 = 0; i8 < EXIF_TAGS.length; i8++) {
            if (!this.mAttributes[i8].isEmpty()) {
                byteOrderedDataOutputStream2.writeUnsignedShort(this.mAttributes[i8].size());
                int size2 = iArr[i8] + 2 + (this.mAttributes[i8].size() * 12) + 4;
                for (Map.Entry next : this.mAttributes[i8].entrySet()) {
                    int i9 = sExifTagMapsForWriting[i8].get(next.getKey()).number;
                    ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                    int size3 = exifAttribute.size();
                    byteOrderedDataOutputStream2.writeUnsignedShort(i9);
                    byteOrderedDataOutputStream2.writeUnsignedShort(exifAttribute.format);
                    byteOrderedDataOutputStream2.writeInt(exifAttribute.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream2.writeUnsignedInt((long) size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream2.write(exifAttribute.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream2.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i8 != 0 || this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream2.writeUnsignedInt(0);
                } else {
                    byteOrderedDataOutputStream2.writeUnsignedInt((long) iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> value2 : this.mAttributes[i8].entrySet()) {
                    byte[] bArr = ((ExifAttribute) value2.getValue()).bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream2.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream2.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && i4 % 2 == 1) {
            byteOrderedDataOutputStream2.writeByte(0);
        }
        byteOrderedDataOutputStream2.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i4;
    }

    public void flipHorizontally() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 2;
                break;
            case 2:
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public void flipVertically() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d;
        }
        if (attributeInt != 1) {
            i = 1;
        }
        return attributeDouble * ((double) i);
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                if (!sTagSetForCompatibility.contains(str)) {
                    return exifAttribute.getStringValue(this.mExifByteOrder);
                }
                if (str.equals(TAG_GPS_TIMESTAMP)) {
                    int i = exifAttribute.format;
                    if (i == 5 || i == 10) {
                        Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                        if (rationalArr == null || rationalArr.length != 3) {
                            Log.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                            return null;
                        }
                        Rational rational = rationalArr[0];
                        Integer valueOf = Integer.valueOf((int) (((float) rational.numerator) / ((float) rational.denominator)));
                        Rational rational2 = rationalArr[1];
                        Integer valueOf2 = Integer.valueOf((int) (((float) rational2.numerator) / ((float) rational2.denominator)));
                        Rational rational3 = rationalArr[2];
                        return String.format("%02d:%02d:%02d", new Object[]{valueOf, valueOf2, Integer.valueOf((int) (((float) rational3.numerator) / ((float) rational3.denominator)))});
                    }
                    Log.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                    return null;
                }
                try {
                    return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                return exifAttribute.bytes;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double getAttributeDouble(@NonNull String str, double d) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return d;
            }
            try {
                return exifAttribute.getDoubleValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return d;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public int getAttributeInt(@NonNull String str, int i) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return i;
            }
            try {
                return exifAttribute.getIntValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return i;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        } else if (!this.mModified) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return null;
            }
            return new long[]{exifAttribute.bytesOffset, (long) exifAttribute.bytes.length};
        } else {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
    }

    @Nullable
    @RestrictTo
    public Long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME), getAttribute(TAG_OFFSET_TIME));
    }

    @Nullable
    @RestrictTo
    public Long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    @Nullable
    @RestrictTo
    public Long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    @SuppressLint({"AutoBoxing"})
    @Nullable
    public Long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (!(attribute == null || attribute2 == null)) {
            Pattern pattern = NON_ZERO_TIME_PATTERN;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                String str = attribute + ' ' + attribute2;
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date parse = sFormatterPrimary.parse(str, parsePosition);
                    if (parse == null && (parse = sFormatterSecondary.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(parse.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return UCarProto.Orientation.ORIENTATION_270_VALUE;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                byte[] bArr = this.mThumbnailBytes;
                int i3 = i2 * 3;
                iArr[i2] = (bArr[i3] << 16) + (bArr[i3 + 1] << 8) + bArr[i3 + 2];
            }
            ExifAttribute exifAttribute = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_WIDTH);
            if (!(exifAttribute == null || exifAttribute2 == null)) {
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0091  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getThumbnailBytes() {
        /*
            r8 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r8.mHasThumbnail
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            byte[] r1 = r8.mThumbnailBytes
            if (r1 == 0) goto L_0x000d
            return r1
        L_0x000d:
            android.content.res.AssetManager$AssetInputStream r1 = r8.mAssetInputStream     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            if (r1 == 0) goto L_0x002d
            boolean r3 = r1.markSupported()     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            if (r3 == 0) goto L_0x0024
            r1.reset()     // Catch:{ Exception -> 0x0021, all -> 0x001c }
        L_0x001a:
            r3 = r2
            goto L_0x0055
        L_0x001c:
            r8 = move-exception
            r3 = r2
        L_0x001e:
            r2 = r1
            goto L_0x008c
        L_0x0021:
            r8 = move-exception
            r3 = r2
            goto L_0x007e
        L_0x0024:
            java.lang.String r8 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r8)     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)
            return r2
        L_0x002d:
            java.lang.String r1 = r8.mFilename     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            if (r1 == 0) goto L_0x0040
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            java.lang.String r3 = r8.mFilename     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            goto L_0x001a
        L_0x0039:
            r8 = move-exception
            r3 = r2
            goto L_0x008c
        L_0x003c:
            r8 = move-exception
            r1 = r2
            r3 = r1
            goto L_0x007e
        L_0x0040:
            java.io.FileDescriptor r1 = r8.mSeekableFileDescriptor     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            java.io.FileDescriptor r1 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.dup(r1)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            int r3 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            r4 = 0
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r1, r4, r3)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            r7 = r3
            r3 = r1
            r1 = r7
        L_0x0055:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r4 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x0076 }
            r4.<init>((java.io.InputStream) r1)     // Catch:{ Exception -> 0x0076 }
            int r5 = r8.mThumbnailOffset     // Catch:{ Exception -> 0x0076 }
            int r6 = r8.mOffsetToExifData     // Catch:{ Exception -> 0x0076 }
            int r5 = r5 + r6
            r4.skipFully(r5)     // Catch:{ Exception -> 0x0076 }
            int r5 = r8.mThumbnailLength     // Catch:{ Exception -> 0x0076 }
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0076 }
            r4.readFully(r5)     // Catch:{ Exception -> 0x0076 }
            r8.mThumbnailBytes = r5     // Catch:{ Exception -> 0x0076 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)
            if (r3 == 0) goto L_0x0073
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r3)
        L_0x0073:
            return r5
        L_0x0074:
            r8 = move-exception
            goto L_0x001e
        L_0x0076:
            r8 = move-exception
            goto L_0x007e
        L_0x0078:
            r8 = move-exception
            r3 = r1
            goto L_0x008c
        L_0x007b:
            r8 = move-exception
            r3 = r1
            r1 = r2
        L_0x007e:
            java.lang.String r4 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r4, r8)     // Catch:{ all -> 0x0074 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)
            if (r3 == 0) goto L_0x008b
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r3)
        L_0x008b:
            return r2
        L_0x008c:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r2)
            if (r3 == 0) goto L_0x0094
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r3)
        L_0x0094:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getThumbnailBytes():byte[]");
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (this.mModified) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        } else if (!this.mHasThumbnail) {
            return null;
        } else {
            if (this.mHasThumbnailStrips && !this.mAreThumbnailStripsConsecutive) {
                return null;
            }
            return new long[]{(long) (this.mThumbnailOffset + this.mOffsetToExifData), (long) this.mThumbnailLength};
        }
    }

    public boolean hasAttribute(@NonNull String str) {
        return getExifAttribute(str) != null;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i = this.mThumbnailCompression;
        return i == 6 || i == 7;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i) {
        if (i % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            List<Integer> list = ROTATION_ORDER;
            int i2 = 0;
            if (list.contains(Integer.valueOf(attributeInt))) {
                int indexOf = (list.indexOf(Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                if (indexOf < 0) {
                    i2 = 4;
                }
                i2 = list.get(indexOf + i2).intValue();
            } else {
                List<Integer> list2 = FLIPPED_ROTATION_ORDER;
                if (list2.contains(Integer.valueOf(attributeInt))) {
                    int indexOf2 = (list2.indexOf(Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                    if (indexOf2 < 0) {
                        i2 = 4;
                    }
                    i2 = list2.get(indexOf2 + i2).intValue();
                }
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i2));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r6v8, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0154, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0085, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0088, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0089, code lost:
        r8 = null;
        r9 = null;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00de, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00df, code lost:
        r9 = null;
        r1 = r6;
        r6 = r8;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f1, code lost:
        androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r13.mSeekableFileDescriptor, 0, android.system.OsConstants.SEEK_SET);
        r1 = new java.io.FileOutputStream(r13.mSeekableFileDescriptor);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0108, code lost:
        r1 = new java.io.FileOutputStream(r13.mFilename);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084 A[Catch:{ Exception -> 0x0088, all -> 0x0084 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:31:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f1 A[Catch:{ Exception -> 0x0105, all -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0108 A[Catch:{ Exception -> 0x0105, all -> 0x0101 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveAttributes() throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r13.mMimeType
            boolean r0 = isSupportedFormatForSavingAttributes(r0)
            if (r0 == 0) goto L_0x0174
            java.io.FileDescriptor r0 = r13.mSeekableFileDescriptor
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r13.mFilename
            if (r0 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r0 = "ExifInterface does not support saving attributes for the current input."
            r13.<init>(r0)
            throw r13
        L_0x0019:
            boolean r0 = r13.mHasThumbnail
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.mHasThumbnailStrips
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.mAreThumbnailStripsConsecutive
            if (r0 == 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r0 = "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
            r13.<init>(r0)
            throw r13
        L_0x002e:
            r0 = 1
            r13.mModified = r0
            byte[] r1 = r13.getThumbnail()
            r13.mThumbnailBytes = r1
            r1 = 0
            java.lang.String r2 = "temp"
            java.lang.String r3 = "tmp"
            java.io.File r2 = java.io.File.createTempFile(r2, r3)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.lang.String r3 = r13.mFilename     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r4 = 0
            if (r3 == 0) goto L_0x0056
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.lang.String r6 = r13.mFilename     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            goto L_0x0064
        L_0x004e:
            r13 = move-exception
            r6 = r1
            goto L_0x016d
        L_0x0052:
            r13 = move-exception
            r6 = r1
            goto L_0x0164
        L_0x0056:
            java.io.FileDescriptor r3 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r3, r4, r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.FileDescriptor r6 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
        L_0x0064:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r6.<init>(r2)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            androidx.exifinterface.media.ExifInterfaceUtils.copy(r3, r6)     // Catch:{ Exception -> 0x015b, all -> 0x0158 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r3)
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r6)
            r3 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00e4, all -> 0x0084 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00e4, all -> 0x0084 }
            java.lang.String r7 = r13.mFilename     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            if (r7 == 0) goto L_0x0090
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.lang.String r8 = r13.mFilename     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            goto L_0x009e
        L_0x0084:
            r13 = move-exception
            r9 = r1
            goto L_0x014c
        L_0x0088:
            r7 = move-exception
            r8 = r1
            r9 = r8
            r1 = r6
        L_0x008c:
            r6 = r7
            r7 = r9
            goto L_0x00e8
        L_0x0090:
            java.io.FileDescriptor r7 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            int r8 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r7, r4, r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.io.FileDescriptor r8 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
        L_0x009e:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00de, all -> 0x0084 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00de, all -> 0x0084 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00d8, all -> 0x00d5 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00d8, all -> 0x00d5 }
            int r10 = r13.mMimeType     // Catch:{ Exception -> 0x00b5 }
            r11 = 4
            if (r10 != r11) goto L_0x00ba
            r13.saveJpegAttributes(r8, r9)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00c9
        L_0x00b1:
            r13 = move-exception
        L_0x00b2:
            r1 = r8
            goto L_0x014c
        L_0x00b5:
            r1 = move-exception
            r12 = r6
            r6 = r1
            r1 = r12
            goto L_0x00e8
        L_0x00ba:
            r11 = 13
            if (r10 != r11) goto L_0x00c2
            r13.savePngAttributes(r8, r9)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00c9
        L_0x00c2:
            r11 = 14
            if (r10 != r11) goto L_0x00c9
            r13.saveWebpAttributes(r8, r9)     // Catch:{ Exception -> 0x00b5 }
        L_0x00c9:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r8)
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r9)
            r2.delete()
            r13.mThumbnailBytes = r1
            return
        L_0x00d5:
            r13 = move-exception
            r9 = r1
            goto L_0x00b2
        L_0x00d8:
            r9 = move-exception
            r12 = r9
            r9 = r1
            r1 = r6
            r6 = r12
            goto L_0x00e8
        L_0x00de:
            r8 = move-exception
            r9 = r1
            r1 = r6
            r6 = r8
            r8 = r9
            goto L_0x00e8
        L_0x00e4:
            r7 = move-exception
            r8 = r1
            r9 = r8
            goto L_0x008c
        L_0x00e8:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.String r1 = r13.mFilename     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            if (r1 != 0) goto L_0x0108
            java.io.FileDescriptor r1 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            int r11 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(r1, r4, r11)     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            java.io.FileDescriptor r13 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            r1.<init>(r13)     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
        L_0x00ff:
            r7 = r1
            goto L_0x0110
        L_0x0101:
            r13 = move-exception
            r0 = r3
            r1 = r10
            goto L_0x0141
        L_0x0105:
            r13 = move-exception
            r1 = r10
            goto L_0x0125
        L_0x0108:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            java.lang.String r13 = r13.mFilename     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            r1.<init>(r13)     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            goto L_0x00ff
        L_0x0110:
            androidx.exifinterface.media.ExifInterfaceUtils.copy(r10, r7)     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r10)     // Catch:{ all -> 0x00b1 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r7)     // Catch:{ all -> 0x00b1 }
            java.io.IOException r13 = new java.io.IOException     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = "Failed to save new file"
            r13.<init>(r0, r6)     // Catch:{ all -> 0x00b1 }
            throw r13     // Catch:{ all -> 0x00b1 }
        L_0x0121:
            r13 = move-exception
            r0 = r3
            goto L_0x0141
        L_0x0124:
            r13 = move-exception
        L_0x0125:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0140 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0140 }
            r4.<init>()     // Catch:{ all -> 0x0140 }
            java.lang.String r5 = "Failed to save new file. Original file is stored in "
            r4.append(r5)     // Catch:{ all -> 0x0140 }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x0140 }
            r4.append(r5)     // Catch:{ all -> 0x0140 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0140 }
            r3.<init>(r4, r13)     // Catch:{ all -> 0x0140 }
            throw r3     // Catch:{ all -> 0x0140 }
        L_0x0140:
            r13 = move-exception
        L_0x0141:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)     // Catch:{ all -> 0x0148 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r7)     // Catch:{ all -> 0x0148 }
            throw r13     // Catch:{ all -> 0x0148 }
        L_0x0148:
            r13 = move-exception
            r3 = r0
            goto L_0x00b2
        L_0x014c:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r9)
            if (r3 != 0) goto L_0x0157
            r2.delete()
        L_0x0157:
            throw r13
        L_0x0158:
            r13 = move-exception
        L_0x0159:
            r1 = r3
            goto L_0x016d
        L_0x015b:
            r13 = move-exception
        L_0x015c:
            r1 = r3
            goto L_0x0164
        L_0x015e:
            r13 = move-exception
            r6 = r1
            goto L_0x0159
        L_0x0161:
            r13 = move-exception
            r6 = r1
            goto L_0x015c
        L_0x0164:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x016c }
            java.lang.String r2 = "Failed to copy original file to temp file"
            r0.<init>(r2, r13)     // Catch:{ all -> 0x016c }
            throw r0     // Catch:{ all -> 0x016c }
        L_0x016c:
            r13 = move-exception
        L_0x016d:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1)
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r6)
            throw r13
        L_0x0174:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r0 = "ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats."
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveAttributes():void");
    }

    public void setAltitude(double d) {
        String str = d >= 0.0d ? "0" : "1";
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0295, code lost:
        r15 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAttribute(@androidx.annotation.NonNull java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            if (r1 == 0) goto L_0x0365
            java.lang.String r3 = "DateTime"
            boolean r3 = r3.equals(r1)
            java.lang.String r4 = " : "
            java.lang.String r5 = "Invalid value for "
            java.lang.String r6 = "ExifInterface"
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeOriginal"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeDigitized"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x006d
        L_0x0026:
            if (r2 == 0) goto L_0x006d
            java.util.regex.Pattern r3 = DATETIME_PRIMARY_FORMAT_PATTERN
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r3 = r3.find()
            java.util.regex.Pattern r7 = DATETIME_SECONDARY_FORMAT_PATTERN
            java.util.regex.Matcher r7 = r7.matcher(r2)
            boolean r7 = r7.find()
            int r8 = r19.length()
            r9 = 19
            if (r8 != r9) goto L_0x0054
            if (r3 != 0) goto L_0x0049
            if (r7 != 0) goto L_0x0049
            goto L_0x0054
        L_0x0049:
            if (r7 == 0) goto L_0x006d
            java.lang.String r3 = "-"
            java.lang.String r7 = ":"
            java.lang.String r2 = r2.replaceAll(r3, r7)
            goto L_0x006d
        L_0x0054:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r1)
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r6, r0)
            return
        L_0x006d:
            java.lang.String r3 = "ISOSpeedRatings"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY."
            android.util.Log.d(r6, r1)
        L_0x007e:
            java.lang.String r1 = "PhotographicSensitivity"
        L_0x0080:
            r3 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0119
            java.util.HashSet<java.lang.String> r8 = sTagSetForCompatibility
            boolean r8 = r8.contains(r1)
            if (r8 == 0) goto L_0x0119
            java.lang.String r8 = "GPSTimeStamp"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x00f2
            java.util.regex.Pattern r8 = GPS_TIMESTAMP_PATTERN
            java.util.regex.Matcher r8 = r8.matcher(r2)
            boolean r9 = r8.find()
            if (r9 != 0) goto L_0x00b9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r1)
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r6, r0)
            return
        L_0x00b9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r8.group(r7)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1,"
            r2.append(r4)
            java.lang.String r5 = r8.group(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            r2.append(r5)
            r2.append(r4)
            r4 = 3
            java.lang.String r4 = r8.group(r4)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x0119
        L_0x00f2:
            double r8 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x0100 }
            androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ NumberFormatException -> 0x0100 }
            r10.<init>(r8)     // Catch:{ NumberFormatException -> 0x0100 }
            java.lang.String r2 = r10.toString()     // Catch:{ NumberFormatException -> 0x0100 }
            goto L_0x0119
        L_0x0100:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r1)
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r6, r0)
            return
        L_0x0119:
            r4 = 0
            r5 = r4
        L_0x011b:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r8 = EXIF_TAGS
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0364
            r8 = 4
            if (r5 != r8) goto L_0x012a
            boolean r8 = r0.mHasThumbnail
            if (r8 != 0) goto L_0x012a
        L_0x0127:
            r15 = r7
            goto L_0x035d
        L_0x012a:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifTag>[] r8 = sExifTagMapsForWriting
            r8 = r8[r5]
            java.lang.Object r8 = r8.get(r1)
            androidx.exifinterface.media.ExifInterface$ExifTag r8 = (androidx.exifinterface.media.ExifInterface.ExifTag) r8
            if (r8 == 0) goto L_0x0127
            if (r2 != 0) goto L_0x0140
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r8 = r0.mAttributes
            r8 = r8[r5]
            r8.remove(r1)
            goto L_0x0127
        L_0x0140:
            android.util.Pair r9 = guessDataFormat(r2)
            int r10 = r8.primaryFormat
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r12 = -1
            if (r10 == r11) goto L_0x0210
            int r10 = r8.primaryFormat
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x015f
            goto L_0x0210
        L_0x015f:
            int r10 = r8.secondaryFormat
            if (r10 == r12) goto L_0x017d
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 == r11) goto L_0x0179
            int r10 = r8.secondaryFormat
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x017d
        L_0x0179:
            int r8 = r8.secondaryFormat
            goto L_0x0212
        L_0x017d:
            int r10 = r8.primaryFormat
            if (r10 == r7) goto L_0x020e
            r11 = 7
            if (r10 == r11) goto L_0x020e
            if (r10 != r3) goto L_0x0188
            goto L_0x020e
        L_0x0188:
            boolean r10 = DEBUG
            if (r10 == 0) goto L_0x0127
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Given tag ("
            r10.append(r11)
            r10.append(r1)
            java.lang.String r11 = ") value didn't match with one of expected formats: "
            r10.append(r11)
            java.lang.String[] r11 = IFD_FORMAT_NAMES
            int r13 = r8.primaryFormat
            r13 = r11[r13]
            r10.append(r13)
            int r13 = r8.secondaryFormat
            java.lang.String r14 = ", "
            java.lang.String r15 = ""
            if (r13 != r12) goto L_0x01b1
            r8 = r15
            goto L_0x01c4
        L_0x01b1:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r14)
            int r8 = r8.secondaryFormat
            r8 = r11[r8]
            r13.append(r8)
            java.lang.String r8 = r13.toString()
        L_0x01c4:
            r10.append(r8)
            java.lang.String r8 = " (guess: "
            r10.append(r8)
            java.lang.Object r8 = r9.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r8 = r11[r8]
            r10.append(r8)
            java.lang.Object r8 = r9.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 != r12) goto L_0x01e4
            goto L_0x01fd
        L_0x01e4:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r14)
            java.lang.Object r9 = r9.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r9 = r11[r9]
            r8.append(r9)
            java.lang.String r15 = r8.toString()
        L_0x01fd:
            r10.append(r15)
            java.lang.String r8 = ")"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            android.util.Log.d(r6, r8)
            goto L_0x0127
        L_0x020e:
            r8 = r10
            goto L_0x0212
        L_0x0210:
            int r8 = r8.primaryFormat
        L_0x0212:
            java.lang.String r9 = "/"
            java.lang.String r10 = ","
            switch(r8) {
                case 1: goto L_0x0351;
                case 2: goto L_0x0344;
                case 3: goto L_0x031e;
                case 4: goto L_0x02f8;
                case 5: goto L_0x02bc;
                case 6: goto L_0x0219;
                case 7: goto L_0x0344;
                case 8: goto L_0x0219;
                case 9: goto L_0x0298;
                case 10: goto L_0x0258;
                case 11: goto L_0x0219;
                case 12: goto L_0x0233;
                default: goto L_0x0219;
            }
        L_0x0219:
            boolean r9 = DEBUG
            if (r9 == 0) goto L_0x0127
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Data format isn't one of expected formats: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.d(r6, r8)
            goto L_0x0127
        L_0x0233:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r9 = r8.length
            double[] r9 = new double[r9]
            r10 = r4
        L_0x023b:
            int r11 = r8.length
            if (r10 >= r11) goto L_0x0249
            r11 = r8[r10]
            double r11 = java.lang.Double.parseDouble(r11)
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x023b
        L_0x0249:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r8 = r0.mAttributes
            r8 = r8[r5]
            java.nio.ByteOrder r10 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createDouble((double[]) r9, (java.nio.ByteOrder) r10)
            r8.put(r1, r9)
            goto L_0x0127
        L_0x0258:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r10 = r8.length
            androidx.exifinterface.media.ExifInterface$Rational[] r10 = new androidx.exifinterface.media.ExifInterface.Rational[r10]
            r11 = r4
        L_0x0260:
            int r13 = r8.length
            if (r11 >= r13) goto L_0x0288
            r13 = r8[r11]
            java.lang.String[] r13 = r13.split(r9, r12)
            androidx.exifinterface.media.ExifInterface$Rational r14 = new androidx.exifinterface.media.ExifInterface$Rational
            r15 = r13[r4]
            double r3 = java.lang.Double.parseDouble(r15)
            long r3 = (long) r3
            r13 = r13[r7]
            r16 = r8
            double r7 = java.lang.Double.parseDouble(r13)
            long r7 = (long) r7
            r14.<init>(r3, r7)
            r10[r11] = r14
            int r11 = r11 + 1
            r8 = r16
            r3 = 2
            r4 = 0
            r7 = 1
            goto L_0x0260
        L_0x0288:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r4 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createSRational((androidx.exifinterface.media.ExifInterface.Rational[]) r10, (java.nio.ByteOrder) r4)
            r3.put(r1, r4)
        L_0x0295:
            r15 = 1
            goto L_0x035d
        L_0x0298:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x02a0:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02ae
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x02a0
        L_0x02ae:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createSLong((int[]) r4, (java.nio.ByteOrder) r7)
            r3.put(r1, r4)
            goto L_0x0295
        L_0x02bc:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            androidx.exifinterface.media.ExifInterface$Rational[] r4 = new androidx.exifinterface.media.ExifInterface.Rational[r4]
            r7 = 0
        L_0x02c4:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02e8
            r8 = r3[r7]
            java.lang.String[] r8 = r8.split(r9, r12)
            androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational
            r11 = 0
            r13 = r8[r11]
            double r13 = java.lang.Double.parseDouble(r13)
            long r13 = (long) r13
            r15 = 1
            r8 = r8[r15]
            double r11 = java.lang.Double.parseDouble(r8)
            long r11 = (long) r11
            r10.<init>(r13, r11)
            r4[r7] = r10
            int r7 = r7 + 1
            r12 = -1
            goto L_0x02c4
        L_0x02e8:
            r15 = 1
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createURational((androidx.exifinterface.media.ExifInterface.Rational[]) r4, (java.nio.ByteOrder) r7)
            r3.put(r1, r4)
            goto L_0x035d
        L_0x02f8:
            r15 = r7
            r3 = r12
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            long[] r4 = new long[r4]
            r7 = 0
        L_0x0302:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0310
            r8 = r3[r7]
            long r8 = java.lang.Long.parseLong(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0302
        L_0x0310:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long[]) r4, (java.nio.ByteOrder) r7)
            r3.put(r1, r4)
            goto L_0x035d
        L_0x031e:
            r15 = r7
            r3 = r12
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x0328:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0336
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0328
        L_0x0336:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int[]) r4, (java.nio.ByteOrder) r7)
            r3.put(r1, r4)
            goto L_0x035d
        L_0x0344:
            r15 = r7
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(r2)
            r3.put(r1, r4)
            goto L_0x035d
        L_0x0351:
            r15 = r7
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createByte(r2)
            r3.put(r1, r4)
        L_0x035d:
            int r5 = r5 + 1
            r7 = r15
            r3 = 2
            r4 = 0
            goto L_0x011b
        L_0x0364:
            return
        L_0x0365:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "tag shouldn't be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.setAttribute(java.lang.String, java.lang.String):void");
    }

    @RestrictTo
    public void setDateTime(@NonNull Long l) {
        if (l == null) {
            throw new NullPointerException("Timestamp should not be null.");
        } else if (l.longValue() >= 0) {
            String l2 = Long.toString(l.longValue() % 1000);
            for (int length = l2.length(); length < 3; length++) {
                l2 = "0" + l2;
            }
            setAttribute(TAG_DATETIME, sFormatterPrimary.format(new Date(l.longValue())));
            setAttribute(TAG_SUBSEC_TIME, l2);
        } else {
            throw new IllegalArgumentException("Timestamp should a positive value.");
        }
    }

    public void setGpsInfo(Location location) {
        if (location != null) {
            setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
            setLatLong(location.getLatitude(), location.getLongitude());
            setAltitude(location.getAltitude());
            setAttribute(TAG_GPS_SPEED_REF, "K");
            setAttribute(TAG_GPS_SPEED, new Rational((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = sFormatterPrimary.format(new Date(location.getTime())).split("\\s+", -1);
            setAttribute(TAG_GPS_DATESTAMP, split[0]);
            setAttribute(TAG_GPS_TIMESTAMP, split[1]);
        }
    }

    public void setLatLong(double d, double d2) {
        if (d < -90.0d || d > 90.0d || Double.isNaN(d)) {
            throw new IllegalArgumentException("Latitude value " + d + " is not valid.");
        } else if (d2 < -180.0d || d2 > 180.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        } else {
            setAttribute(TAG_GPS_LATITUDE_REF, d >= 0.0d ? "N" : LATITUDE_SOUTH);
            setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d)));
            setAttribute(TAG_GPS_LONGITUDE_REF, d2 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
            setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d2)));
        }
    }

    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        public static final int LENGTH_UNSET = -1;
        private ByteOrder mByteOrder;
        protected final DataInputStream mDataInputStream;
        private int mLength;
        protected int mPosition;
        private byte[] mSkipBuffer;

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
            this.mLength = bArr.length;
        }

        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int length() {
            return this.mLength;
        }

        public void mark(int i) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int position() {
            return this.mPosition;
        }

        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        public byte readByte() throws IOException {
            this.mPosition++;
            int read = this.mDataInputStream.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.mPosition += i2;
            this.mDataInputStream.readFully(bArr, i, i2);
        }

        public int readInt() throws IOException {
            this.mPosition += 4;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            int read3 = this.mDataInputStream.read();
            int read4 = this.mDataInputStream.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == ByteOrder.BIG_ENDIAN) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            Log.d(ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        public long readLong() throws IOException {
            this.mPosition += 8;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            int read3 = this.mDataInputStream.read();
            int read4 = this.mDataInputStream.read();
            int read5 = this.mDataInputStream.read();
            int read6 = this.mDataInputStream.read();
            int read7 = this.mDataInputStream.read();
            int read8 = this.mDataInputStream.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i = read2;
                if (byteOrder == ByteOrder.BIG_ENDIAN) {
                    return (((long) read) << 56) + (((long) i) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            int i;
            this.mPosition += 2;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                    i = (read2 << 8) + read;
                } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                    i = (read << 8) + read2;
                } else {
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                return (short) i;
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public int readUnsignedShort() throws IOException {
            this.mPosition += 2;
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == ByteOrder.BIG_ENDIAN) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public int skipBytes(int i) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public void skipFully(int i) throws IOException {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                int skip = (int) this.mDataInputStream.skip((long) i3);
                if (skip <= 0) {
                    if (this.mSkipBuffer == null) {
                        this.mSkipBuffer = new byte[8192];
                    }
                    skip = this.mDataInputStream.read(this.mSkipBuffer, 0, Math.min(8192, i3));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i + " bytes.");
                    }
                }
                i2 += skip;
            }
            this.mPosition += i2;
        }

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            this.mPosition += bArr.length;
            this.mDataInputStream.readFully(bArr);
        }

        public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            dataInputStream.mark(0);
            this.mPosition = 0;
            this.mByteOrder = byteOrder;
            this.mLength = inputStream instanceof ByteOrderedDataInputStream ? ((ByteOrderedDataInputStream) inputStream).length() : -1;
        }
    }

    public static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        public SeekableByteOrderedDataInputStream(byte[] bArr) throws IOException {
            super(bArr);
            this.mDataInputStream.mark(Integer.MAX_VALUE);
        }

        public void seek(long j) throws IOException {
            int i = this.mPosition;
            if (((long) i) > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
            } else {
                j -= (long) i;
            }
            skipFully((int) j);
        }

        public SeekableByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.mDataInputStream.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            Log.w(TAG, "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{attribute, attribute2, attribute3, attribute4}));
            return null;
        }
    }

    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        public boolean isFormatCompatible(int i) {
            int i2;
            int i3 = this.primaryFormat;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.secondaryFormat) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }

        public ExifTag(String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            initForFilename(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExifInterface(@androidx.annotation.NonNull java.io.FileDescriptor r4) throws java.io.IOException {
        /*
            r3 = this;
            r3.<init>()
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r0 = EXIF_TAGS
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r3.mAttributes = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r3.mAttributesOffsets = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r3.mExifByteOrder = r0
            if (r4 == 0) goto L_0x0055
            r0 = 0
            r3.mAssetInputStream = r0
            r3.mFilename = r0
            boolean r1 = isSeekableFD(r4)
            if (r1 == 0) goto L_0x0034
            r3.mSeekableFileDescriptor = r4
            java.io.FileDescriptor r4 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.dup(r4)     // Catch:{ Exception -> 0x002b }
            r1 = 1
            goto L_0x0037
        L_0x002b:
            r3 = move-exception
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r0 = "Failed to duplicate file descriptor"
            r4.<init>(r0, r3)
            throw r4
        L_0x0034:
            r3.mSeekableFileDescriptor = r0
            r1 = 0
        L_0x0037:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x004b }
            r2.<init>(r4)     // Catch:{ all -> 0x004b }
            r3.loadAttributes(r2)     // Catch:{ all -> 0x0048 }
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r2)
            if (r1 == 0) goto L_0x0047
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r4)
        L_0x0047:
            return
        L_0x0048:
            r3 = move-exception
            r0 = r2
            goto L_0x004c
        L_0x004b:
            r3 = move-exception
        L_0x004c:
            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r0)
            if (r1 == 0) goto L_0x0054
            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(r4)
        L_0x0054:
            throw r3
        L_0x0055:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "fileDescriptor cannot be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.io.FileDescriptor):void");
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            if (i == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, IDENTIFIER_EXIF_APP1.length);
                if (!isExifDataOnly(bufferedInputStream)) {
                    Log.w(TAG, "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.mIsExifDataOnly = true;
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (isSeekableFD(fileInputStream.getFD())) {
                        this.mAssetInputStream = null;
                        this.mSeekableFileDescriptor = fileInputStream.getFD();
                    }
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
