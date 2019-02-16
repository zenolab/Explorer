package com.online_viewer_mo_apps.zenolab.explorer.adapter.factory;

import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.online_viewer_mo_apps.zenolab.explorer.R;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.GenericViewHolder;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.listener.ItemActionListener;
import com.online_viewer_mo_apps.zenolab.explorer.domain.pojo.DirectoryEntity;
import com.online_viewer_mo_apps.zenolab.explorer.domain.pojo.FileEntity;
import com.online_viewer_mo_apps.zenolab.explorer.domain.pojo.UserGroupsEntity;

import java.util.List;

public class ViewHolderFactory {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();


    public static GenericViewHolder create(ViewGroup parent, int viewType) {

        switch (viewType) {

            case ItemType.GROUP_ROW_TYPE:
                View buttonTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_user_groups, parent, false);
                return new ViewHolderFactory.UserGroupViewHolder(buttonTypeView);

            case ItemType.DIRECTORY_ROW_TYPE:
                View textTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_directory, parent, false);
                return new ViewHolderFactory.DirectoryViewHolder(textTypeView);

            case ItemType.FILE_ROW_TYPE:
                View imageTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_file, parent, false);
                return new ViewHolderFactory.FileViewHolder(imageTypeView);

            default:
                throw new RuntimeException("Not found holder");
        }
    }

    //-------------------------------------------------------------------------------

        public static class UserGroupViewHolder extends GenericViewHolder {

            @BindView(R.id.group_text)
            TextView headerUserGroupTextView;
            @BindView(R.id.user_card_layout)
            CardView userCardView;

            public UserGroupViewHolder(View view) {
                super(view);
                ButterKnife.setDebug(true);
                ButterKnife.bind(this, itemView);

            }

            @Override
            public void setDataOnView(GenericViewHolder holder, int position,
                                      List<ItemType> dataSet,ItemActionListener itemActionListener) {

                UserGroupsEntity userGroupsEntity = (UserGroupsEntity) dataSet.get(position);
                ((UserGroupViewHolder) holder ).headerUserGroupTextView.setText(userGroupsEntity.getTitle());


                userCardView.setOnClickListener(v -> {
                    Log.d("FactoryItem","Click ");
                    itemActionListener.clickOnGroup(position);

                });
            }
        }

        public static class DirectoryViewHolder extends GenericViewHolder  {

            public TextView headerDirectoryTextView;
            public TextView textDirectoryView;
            CardView directory_cardView;

            public DirectoryViewHolder(View itemView) {
                super(itemView);



                headerDirectoryTextView = (TextView) itemView.findViewById(R.id.directory_header);
                textDirectoryView = (TextView) itemView.findViewById(R.id.directory_text);
                directory_cardView = (CardView) itemView.findViewById(R.id.directory_card_layout);

            }

            @Override
            public void setDataOnView(GenericViewHolder holder, int position,
                                      List<ItemType> dataSet,ItemActionListener itemActionListener) {

                 DirectoryEntity directoryEntity = (DirectoryEntity) dataSet.get(position);
                ((DirectoryViewHolder) holder).headerDirectoryTextView.setText(directoryEntity.getTitle());
                ((DirectoryViewHolder) holder).textDirectoryView.setText(""+directoryEntity.getId());

                directory_cardView.setOnClickListener(v -> {
                    Log.d("FactoryItem","Click ");
                    itemActionListener.clickOnDirectory(position);

                });
            }
        }

        public static class FileViewHolder extends GenericViewHolder  {

            public TextView headerFileTextView;
            public TextView textFileView;
            CardView fileCardView;

            public FileViewHolder(View itemView) {
                super(itemView);
                headerFileTextView = (TextView) itemView.findViewById(R.id.file_header);
                textFileView = (TextView) itemView.findViewById(R.id.file_text);
                fileCardView = (CardView) itemView.findViewById(R.id.file_card_layout);
            }

            @Override
            public void setDataOnView(GenericViewHolder holder, int position,
                                      List<ItemType> dataSet,ItemActionListener itemActionListener) {

                FileEntity fileEntity = (FileEntity) dataSet.get(position);
                ((FileViewHolder) holder).headerFileTextView.setText(fileEntity.getTitle());
                ((FileViewHolder) holder).textFileView.setText(""+fileEntity.getId());

                fileCardView.setOnClickListener(v -> {
                    itemActionListener.clickOnFile(position);
                    Log.d("FactoryItem","Click ");
                });
            }
        }

}
