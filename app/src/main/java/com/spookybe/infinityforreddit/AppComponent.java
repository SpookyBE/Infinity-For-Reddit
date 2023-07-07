package com.spookybe.infinityforreddit;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import com.spookybe.infinityforreddit.activities.AccountPostsActivity;
import com.spookybe.infinityforreddit.activities.AccountSavedThingActivity;
import com.spookybe.infinityforreddit.activities.CommentActivity;
import com.spookybe.infinityforreddit.activities.CreateMultiRedditActivity;
import com.spookybe.infinityforreddit.activities.CustomThemeListingActivity;
import com.spookybe.infinityforreddit.activities.CustomThemePreviewActivity;
import com.spookybe.infinityforreddit.activities.CustomizePostFilterActivity;
import com.spookybe.infinityforreddit.activities.CustomizeThemeActivity;
import com.spookybe.infinityforreddit.activities.EditCommentActivity;
import com.spookybe.infinityforreddit.activities.EditMultiRedditActivity;
import com.spookybe.infinityforreddit.activities.EditPostActivity;
import com.spookybe.infinityforreddit.activities.EditProfileActivity;
import com.spookybe.infinityforreddit.activities.FetchRandomSubredditOrPostActivity;
import com.spookybe.infinityforreddit.activities.FilteredPostsActivity;
import com.spookybe.infinityforreddit.activities.FullMarkdownActivity;
import com.spookybe.infinityforreddit.activities.GiveAwardActivity;
import com.spookybe.infinityforreddit.activities.HistoryActivity;
import com.spookybe.infinityforreddit.activities.InboxActivity;
import com.spookybe.infinityforreddit.activities.LinkResolverActivity;
import com.spookybe.infinityforreddit.activities.LockScreenActivity;
import com.spookybe.infinityforreddit.activities.LoginActivity;
import com.spookybe.infinityforreddit.activities.MainActivity;
import com.spookybe.infinityforreddit.activities.MultiredditSelectionActivity;
import com.spookybe.infinityforreddit.activities.PostFilterPreferenceActivity;
import com.spookybe.infinityforreddit.activities.PostFilterUsageListingActivity;
import com.spookybe.infinityforreddit.activities.PostGalleryActivity;
import com.spookybe.infinityforreddit.activities.PostImageActivity;
import com.spookybe.infinityforreddit.activities.PostLinkActivity;
import com.spookybe.infinityforreddit.activities.PostPollActivity;
import com.spookybe.infinityforreddit.activities.PostTextActivity;
import com.spookybe.infinityforreddit.activities.PostVideoActivity;
import com.spookybe.infinityforreddit.activities.ReportActivity;
import com.spookybe.infinityforreddit.activities.RulesActivity;
import com.spookybe.infinityforreddit.activities.SearchActivity;
import com.spookybe.infinityforreddit.activities.SearchResultActivity;
import com.spookybe.infinityforreddit.activities.SearchSubredditsResultActivity;
import com.spookybe.infinityforreddit.activities.SearchUsersResultActivity;
import com.spookybe.infinityforreddit.activities.SelectUserFlairActivity;
import com.spookybe.infinityforreddit.activities.SelectedSubredditsAndUsersActivity;
import com.spookybe.infinityforreddit.activities.SendPrivateMessageActivity;
import com.spookybe.infinityforreddit.activities.SettingsActivity;
import com.spookybe.infinityforreddit.activities.SubmitCrosspostActivity;
import com.spookybe.infinityforreddit.activities.SubredditMultiselectionActivity;
import com.spookybe.infinityforreddit.activities.SubredditSelectionActivity;
import com.spookybe.infinityforreddit.activities.SubscribedThingListingActivity;
import com.spookybe.infinityforreddit.activities.SuicidePreventionActivity;
import com.spookybe.infinityforreddit.activities.TrendingActivity;
import com.spookybe.infinityforreddit.activities.ViewImageOrGifActivity;
import com.spookybe.infinityforreddit.activities.ViewImgurMediaActivity;
import com.spookybe.infinityforreddit.activities.ViewMultiRedditDetailActivity;
import com.spookybe.infinityforreddit.activities.ViewPostDetailActivity;
import com.spookybe.infinityforreddit.activities.ViewPrivateMessagesActivity;
import com.spookybe.infinityforreddit.activities.ViewRedditGalleryActivity;
import com.spookybe.infinityforreddit.activities.ViewSubredditDetailActivity;
import com.spookybe.infinityforreddit.activities.ViewUserDetailActivity;
import com.spookybe.infinityforreddit.activities.ViewVideoActivity;
import com.spookybe.infinityforreddit.activities.WebViewActivity;
import com.spookybe.infinityforreddit.activities.WikiActivity;
import com.spookybe.infinityforreddit.bottomsheetfragments.AccountChooserBottomSheetFragment;
import com.spookybe.infinityforreddit.bottomsheetfragments.FlairBottomSheetFragment;
import com.spookybe.infinityforreddit.fragments.CommentsListingFragment;
import com.spookybe.infinityforreddit.fragments.FollowedUsersListingFragment;
import com.spookybe.infinityforreddit.fragments.HistoryPostFragment;
import com.spookybe.infinityforreddit.fragments.InboxFragment;
import com.spookybe.infinityforreddit.fragments.MorePostsInfoFragment;
import com.spookybe.infinityforreddit.fragments.MultiRedditListingFragment;
import com.spookybe.infinityforreddit.fragments.PostFragment;
import com.spookybe.infinityforreddit.fragments.SidebarFragment;
import com.spookybe.infinityforreddit.fragments.SubredditListingFragment;
import com.spookybe.infinityforreddit.fragments.SubscribedSubredditsListingFragment;
import com.spookybe.infinityforreddit.fragments.UserListingFragment;
import com.spookybe.infinityforreddit.fragments.ViewImgurImageFragment;
import com.spookybe.infinityforreddit.fragments.ViewImgurVideoFragment;
import com.spookybe.infinityforreddit.fragments.ViewPostDetailFragment;
import com.spookybe.infinityforreddit.fragments.ViewRedditGalleryImageOrGifFragment;
import com.spookybe.infinityforreddit.fragments.ViewRedditGalleryVideoFragment;
import com.spookybe.infinityforreddit.services.DownloadMediaService;
import com.spookybe.infinityforreddit.services.DownloadRedditVideoService;
import com.spookybe.infinityforreddit.services.EditProfileService;
import com.spookybe.infinityforreddit.services.SubmitPostService;
import com.spookybe.infinityforreddit.settings.AdvancedPreferenceFragment;
import com.spookybe.infinityforreddit.settings.CommentPreferenceFragment;
import com.spookybe.infinityforreddit.settings.CrashReportsFragment;
import com.spookybe.infinityforreddit.settings.CustomizeBottomAppBarFragment;
import com.spookybe.infinityforreddit.settings.CustomizeMainPageTabsFragment;
import com.spookybe.infinityforreddit.settings.DownloadLocationPreferenceFragment;
import com.spookybe.infinityforreddit.settings.FontPreferenceFragment;
import com.spookybe.infinityforreddit.settings.GesturesAndButtonsPreferenceFragment;
import com.spookybe.infinityforreddit.settings.MainPreferenceFragment;
import com.spookybe.infinityforreddit.settings.MiscellaneousPreferenceFragment;
import com.spookybe.infinityforreddit.settings.NotificationPreferenceFragment;
import com.spookybe.infinityforreddit.settings.NsfwAndSpoilerFragment;
import com.spookybe.infinityforreddit.settings.PostHistoryFragment;
import com.spookybe.infinityforreddit.settings.SecurityPreferenceFragment;
import com.spookybe.infinityforreddit.settings.ThemePreferenceFragment;
import com.spookybe.infinityforreddit.settings.TranslationFragment;
import com.spookybe.infinityforreddit.settings.VideoPreferenceFragment;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(PostFragment postFragment);

    void inject(SubredditListingFragment subredditListingFragment);

    void inject(UserListingFragment userListingFragment);

    void inject(ViewPostDetailActivity viewPostDetailActivity);

    void inject(ViewSubredditDetailActivity viewSubredditDetailActivity);

    void inject(ViewUserDetailActivity viewUserDetailActivity);

    void inject(CommentActivity commentActivity);

    void inject(SubscribedThingListingActivity subscribedThingListingActivity);

    void inject(PostTextActivity postTextActivity);

    void inject(SubscribedSubredditsListingFragment subscribedSubredditsListingFragment);

    void inject(PostLinkActivity postLinkActivity);

    void inject(PostImageActivity postImageActivity);

    void inject(PostVideoActivity postVideoActivity);

    void inject(FlairBottomSheetFragment flairBottomSheetFragment);

    void inject(RulesActivity rulesActivity);

    void inject(CommentsListingFragment commentsListingFragment);

    void inject(SubmitPostService submitPostService);

    void inject(FilteredPostsActivity filteredPostsActivity);

    void inject(SearchResultActivity searchResultActivity);

    void inject(SearchSubredditsResultActivity searchSubredditsResultActivity);

    void inject(FollowedUsersListingFragment followedUsersListingFragment);

    void inject(SubredditSelectionActivity subredditSelectionActivity);

    void inject(EditPostActivity editPostActivity);

    void inject(EditCommentActivity editCommentActivity);

    void inject(AccountPostsActivity accountPostsActivity);

    void inject(PullNotificationWorker pullNotificationWorker);

    void inject(InboxActivity inboxActivity);

    void inject(NotificationPreferenceFragment notificationPreferenceFragment);

    void inject(LinkResolverActivity linkResolverActivity);

    void inject(SearchActivity searchActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(MainPreferenceFragment mainPreferenceFragment);

    void inject(AccountSavedThingActivity accountSavedThingActivity);

    void inject(ViewImageOrGifActivity viewGIFActivity);

    void inject(ViewMultiRedditDetailActivity viewMultiRedditDetailActivity);

    void inject(ViewVideoActivity viewVideoActivity);

    void inject(GesturesAndButtonsPreferenceFragment gesturesAndButtonsPreferenceFragment);

    void inject(CreateMultiRedditActivity createMultiRedditActivity);

    void inject(SubredditMultiselectionActivity subredditMultiselectionActivity);

    void inject(ThemePreferenceFragment themePreferenceFragment);

    void inject(CustomizeThemeActivity customizeThemeActivity);

    void inject(CustomThemeListingActivity customThemeListingActivity);

    void inject(SidebarFragment sidebarFragment);

    void inject(AdvancedPreferenceFragment advancedPreferenceFragment);

    void inject(CustomThemePreviewActivity customThemePreviewActivity);

    void inject(EditMultiRedditActivity editMultiRedditActivity);

    void inject(SelectedSubredditsAndUsersActivity selectedSubredditsAndUsersActivity);

    void inject(ReportActivity reportActivity);

    void inject(ViewImgurMediaActivity viewImgurMediaActivity);

    void inject(ViewImgurVideoFragment viewImgurVideoFragment);

    void inject(DownloadRedditVideoService downloadRedditVideoService);

    void inject(MultiRedditListingFragment multiRedditListingFragment);

    void inject(InboxFragment inboxFragment);

    void inject(ViewPrivateMessagesActivity viewPrivateMessagesActivity);

    void inject(SendPrivateMessageActivity sendPrivateMessageActivity);

    void inject(VideoPreferenceFragment videoPreferenceFragment);

    void inject(ViewRedditGalleryActivity viewRedditGalleryActivity);

    void inject(ViewRedditGalleryVideoFragment viewRedditGalleryVideoFragment);

    void inject(CustomizeMainPageTabsFragment customizeMainPageTabsFragment);

    void inject(DownloadMediaService downloadMediaService);

    void inject(DownloadLocationPreferenceFragment downloadLocationPreferenceFragment);

    void inject(SubmitCrosspostActivity submitCrosspostActivity);

    void inject(FullMarkdownActivity fullMarkdownActivity);

    void inject(SelectUserFlairActivity selectUserFlairActivity);

    void inject(SecurityPreferenceFragment securityPreferenceFragment);

    void inject(NsfwAndSpoilerFragment nsfwAndSpoilerFragment);

    void inject(CustomizeBottomAppBarFragment customizeBottomAppBarFragment);

    void inject(GiveAwardActivity giveAwardActivity);

    void inject(TranslationFragment translationFragment);

    void inject(FetchRandomSubredditOrPostActivity fetchRandomSubredditOrPostActivity);

    void inject(MiscellaneousPreferenceFragment miscellaneousPreferenceFragment);

    void inject(CustomizePostFilterActivity customizePostFilterActivity);

    void inject(PostHistoryFragment postHistoryFragment);

    void inject(PostFilterPreferenceActivity postFilterPreferenceActivity);

    void inject(PostFilterUsageListingActivity postFilterUsageListingActivity);

    void inject(SearchUsersResultActivity searchUsersResultActivity);

    void inject(MultiredditSelectionActivity multiredditSelectionActivity);

    void inject(ViewImgurImageFragment viewImgurImageFragment);

    void inject(ViewRedditGalleryImageOrGifFragment viewRedditGalleryImageOrGifFragment);

    void inject(ViewPostDetailFragment viewPostDetailFragment);

    void inject(SuicidePreventionActivity suicidePreventionActivity);

    void inject(WebViewActivity webViewActivity);

    void inject(CrashReportsFragment crashReportsFragment);

    void inject(LockScreenActivity lockScreenActivity);

    void inject(PostGalleryActivity postGalleryActivity);

    void inject(TrendingActivity trendingActivity);

    void inject(WikiActivity wikiActivity);

    void inject(Infinity infinity);

    void inject(EditProfileService editProfileService);

    void inject(EditProfileActivity editProfileActivity);

    void inject(FontPreferenceFragment fontPreferenceFragment);

    void inject(CommentPreferenceFragment commentPreferenceFragment);

    void inject(PostPollActivity postPollActivity);

    void inject(AccountChooserBottomSheetFragment accountChooserBottomSheetFragment);

    void inject(MaterialYouWorker materialYouWorker);

    void inject(HistoryPostFragment historyPostFragment);

    void inject(HistoryActivity historyActivity);

    void inject(MorePostsInfoFragment morePostsInfoFragment);

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application application);
    }
}
