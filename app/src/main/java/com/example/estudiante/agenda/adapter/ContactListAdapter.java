package com.example.estudiante.agenda.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.estudiante.agenda.Model.Contact;
import com.example.estudiante.agenda.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Estudiante on 29/10/2015.
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>{

    private ArrayList<Contact> data;

    public ContactListAdapter(ArrayList<Contact> data){ this.data = data; }

    public void setData(ArrayList<Contact> data) {  this.data = data;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = data.get(position);
        holder.bindHolder(contact);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.tv_name) TextView tvName;
        @Bind(R.id.tv_email) TextView tvMail;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindHolder(Contact contact){
            tvName.setText(contact.getName());
            tvMail.setText(contact.getEmail());
        }
    }
}
