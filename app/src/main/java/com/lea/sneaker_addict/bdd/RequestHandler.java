package com.lea.sneaker_addict.bdd;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;


public class RequestHandler {
    private static RequestHandler instanceReqHandler;
    private RequestQueue requestQueueReqHandler;
    //private ImageLoader imageLoaderReqHandler;
    private static Context ctx;

    private RequestHandler(Context context) {
        ctx = context;
        requestQueueReqHandler = getRequestQueue();

        /*imageLoaderReqHandler = new ImageLoader(requestQueueReqHandler,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });*/
    }

    public static synchronized RequestHandler getInstance(Context context) {
        if (instanceReqHandler == null) {
            instanceReqHandler = new RequestHandler(context);
        }
        return instanceReqHandler;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueueReqHandler == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueueReqHandler = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueueReqHandler;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

   /* public ImageLoader getImageLoader() {
        return imageLoaderReqHandler;
    }*/
}
