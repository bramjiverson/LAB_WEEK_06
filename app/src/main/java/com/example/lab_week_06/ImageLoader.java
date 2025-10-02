package com.example.lab_week_06;

import android.widget.ImageView;

/**
 * An interface for loading an image from a URL into an ImageView.
 * This provides an abstraction layer over a specific image loading library (like Glide or Picasso).
 */
public interface ImageLoader {
    /**
     * Loads an image from the given URL into the specified ImageView.
     *
     * @param imageUrl  The URL of the image to load.
     * @param imageView The ImageView where the image will be displayed.
     */
    void loadImage(String imageUrl, ImageView imageView);
}
