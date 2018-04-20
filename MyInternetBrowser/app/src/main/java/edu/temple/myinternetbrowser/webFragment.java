package edu.temple.myinternetbrowser;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class webFragment extends Fragment {

    View view;
    onUrlChange callback;

    public webFragment() {
        // Required empty public constructor
    }

    // Container Activity must implement this interface
    public interface onUrlChange {
        public void onUrlChange(String url);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onUrlChange) {
            callback = (onUrlChange) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_web, container, false);
        if(getArguments() != null){
            WebView webView = view.findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(getArguments().getString("url"));
            callback.onUrlChange(getArguments().getString("url"));
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //Toast.makeText(getContext(), "detached", Toast.LENGTH_SHORT).show();
    }


}
