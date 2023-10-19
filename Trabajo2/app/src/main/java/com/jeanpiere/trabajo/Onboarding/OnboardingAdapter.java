package com.jeanpiere.trabajo.Onboarding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeanpiere.trabajo.R;


import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>{

    private List<OnboardingItem> onboardingItems;

    public OnboardingAdapter(List<OnboardingItem> onboardingItems) {
        this.onboardingItems = onboardingItems;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.activity_intro_onboarding, parent, false
                )
        );

    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingItems.get(position));


    }

    @Override
    public int getItemCount() {
        return onboardingItems.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder{

        private TextView textTitle;

        private TextView texTitle2;

        private TextView texTitle3;

        private TextView texTitle4;

        private TextView texTitle5;

        private TextView texTitle6;

        private TextView texTitle7;

        private TextView texTitle8;

        private TextView texTitle9;


        private TextView textDescription;
        private ImageView imageOnboarding;






        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            texTitle2 = itemView.findViewById(R.id.textTitle2);
            texTitle3 = itemView.findViewById(R.id.textTitle3);
            texTitle4 = itemView.findViewById(R.id.textTitle4);
            texTitle5 = itemView.findViewById(R.id.textTitle5);
            texTitle6 = itemView.findViewById(R.id.textTitle6);
            texTitle7 = itemView.findViewById(R.id.textTitle7);
            texTitle8 = itemView.findViewById(R.id.textTitle8);
            texTitle9 = itemView.findViewById(R.id.textTitle9);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageOnboarding = itemView.findViewById(R.id.imageOnboarding);
        }

        void setOnboardingData(OnboardingItem onboardingItem) {

            textTitle.setText(onboardingItem.getTitle());
            texTitle2.setText(onboardingItem.getTitle2());
            texTitle3.setText(onboardingItem.getTitle3());
            texTitle4.setText(onboardingItem.getTitle4());
            texTitle5.setText(onboardingItem.getTitle5());
            texTitle6.setText(onboardingItem.getTitle6());
            texTitle7.setText(onboardingItem.getTitle7());
            texTitle8.setText(onboardingItem.getTitle8());
            texTitle9.setText(onboardingItem.getTitle9());
            textDescription.setText(onboardingItem.getDescription());
            imageOnboarding.setImageResource(onboardingItem.getImage());
        }
        public void setOnboardingData(OnboardingAdapter onboardingAdapter) {
        }
    }
}
