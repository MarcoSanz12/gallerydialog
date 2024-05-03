package com.marcosanz.gallerydialog.dialog

import android.os.Parcel
import android.os.Parcelable

data class GalleryDialogOptions(

    // FileProvider authorities
    /**
     * The authority of a FileProvider, necessary to share a File
     * You can define it like this:
     *
     * Create in your main module res/xml/paths.xml
     * ```
     * <paths>
     *     <cache-path
     *         name="shared_images"
     *         path="images/"/>
     * </paths>
     *```
     * Then declare in your main module AndroidManifest.xml
     * ```
     * <provider
     *   android:name="androidx.core.content.FileProvider"
     *   android:authorities="com.marcosanz.gallerydialog" // Here use your module location
     *   android:exported="false"
     *   android:grantUriPermissions="true">
     *      <meta-data
     *          android:name="android.support.FILE_PROVIDER_PATHS"
     *          android:resource="@xml/paths" />
     * </provider>
     *
     *  ```
     */
    val fileProviderAuthorities: String? = null,

    // MESSAGES

    /** Text shown in the Intent sharing chooser */
    val messageSharing: String? = null,

    /** Text shown when image download begins */
    val messageDownloading: String? = null,

    /** Text shown when image is downloaded successfully */
    val messageSuccessfulDownload: String? = null,

    /**
     * Text shown when image download fails for any reason
     */
    val messageErrorDownload: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fileProviderAuthorities)
        parcel.writeString(messageSharing)
        parcel.writeString(messageDownloading)
        parcel.writeString(messageSuccessfulDownload)
        parcel.writeString(messageErrorDownload)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GalleryDialogOptions> {
        override fun createFromParcel(parcel: Parcel): GalleryDialogOptions {
            return GalleryDialogOptions(parcel)
        }

        override fun newArray(size: Int): Array<GalleryDialogOptions?> {
            return arrayOfNulls(size)
        }
    }

}