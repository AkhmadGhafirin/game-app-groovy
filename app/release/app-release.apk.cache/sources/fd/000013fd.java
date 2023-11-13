package com.cascer.game_app_groovy.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cascer.game_app_groovy.R;
import com.cascer.game_app_groovy.core.data.Resource;
import com.cascer.game_app_groovy.core.domain.model.Game;
import com.cascer.game_app_groovy.core.ui.GameAdapter;
import com.cascer.game_app_groovy.core.utils.ExtensionKt;
import com.cascer.game_app_groovy.databinding.ActivityHomeBinding;
import com.cascer.game_app_groovy.detail.DetailActivity;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: HomeActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/cascer/game_app_groovy/home/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/cascer/game_app_groovy/databinding/ActivityHomeBinding;", "gameAdapter", "Lcom/cascer/game_app_groovy/core/ui/GameAdapter;", "getGameAdapter", "()Lcom/cascer/game_app_groovy/core/ui/GameAdapter;", "gameAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/cascer/game_app_groovy/home/HomeViewModel;", "getViewModel", "()Lcom/cascer/game_app_groovy/home/HomeViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setupView", "setupViewModel", "toDetail", "game", "Lcom/cascer/game_app_groovy/core/domain/model/Game;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@AndroidEntryPoint
/* loaded from: classes.dex */
public final class HomeActivity extends Hilt_HomeActivity {
    private ActivityHomeBinding binding;
    private final Lazy gameAdapter$delegate = LazyKt.lazy(new Function0<GameAdapter>() { // from class: com.cascer.game_app_groovy.home.HomeActivity$gameAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GameAdapter invoke() {
            final HomeActivity homeActivity = HomeActivity.this;
            return new GameAdapter(new Function1<Game, Unit>() { // from class: com.cascer.game_app_groovy.home.HomeActivity$gameAdapter$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Game game) {
                    invoke2(game);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Game it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    HomeActivity.this.toDetail(it);
                }
            });
        }
    });
    private final Lazy viewModel$delegate;

    public HomeActivity() {
        final HomeActivity homeActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0<ViewModelStore>() { // from class: com.cascer.game_app_groovy.home.HomeActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cascer.game_app_groovy.home.HomeActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.cascer.game_app_groovy.home.HomeActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? homeActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameAdapter getGameAdapter() {
        return (GameAdapter) this.gameAdapter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityHomeBinding inflate = ActivityHomeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setupView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        setupViewModel();
    }

    private final void setupView() {
        ActivityHomeBinding activityHomeBinding = this.binding;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityHomeBinding = null;
        }
        RecyclerView recyclerView = activityHomeBinding.rvList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.setAdapter(getGameAdapter());
        activityHomeBinding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.cascer.game_app_groovy.home.HomeActivity$$ExternalSyntheticLambda0
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                z = HomeActivity.setupView$lambda$2$lambda$1(HomeActivity.this, menuItem);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupView$lambda$2$lambda$1(HomeActivity this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (menuItem.getItemId() == R.id.favorites) {
            this$0.startActivity(new Intent(this$0, Class.forName("com.cascer.game_app_groovy.favorite.FavoriteActivity")));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toDetail(Game game) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_DATA, game);
        startActivity(intent);
    }

    private final void setupViewModel() {
        getViewModel().getGames().observe(this, new HomeActivity$sam$androidx_lifecycle_Observer$0(new Function1<Resource<List<? extends Game>>, Unit>() { // from class: com.cascer.game_app_groovy.home.HomeActivity$setupViewModel$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<List<? extends Game>> resource) {
                invoke2((Resource<List<Game>>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<List<Game>> resource) {
                ActivityHomeBinding activityHomeBinding;
                ActivityHomeBinding activityHomeBinding2;
                ActivityHomeBinding activityHomeBinding3;
                ActivityHomeBinding activityHomeBinding4;
                ActivityHomeBinding activityHomeBinding5;
                GameAdapter gameAdapter;
                ActivityHomeBinding activityHomeBinding6;
                ActivityHomeBinding activityHomeBinding7;
                if (resource != null) {
                    ActivityHomeBinding activityHomeBinding8 = null;
                    if (resource instanceof Resource.Success) {
                        activityHomeBinding3 = HomeActivity.this.binding;
                        if (activityHomeBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityHomeBinding3 = null;
                        }
                        ProgressBar progressbar = activityHomeBinding3.progressbar;
                        Intrinsics.checkNotNullExpressionValue(progressbar, "progressbar");
                        ExtensionKt.gone(progressbar);
                        List<Game> data = resource.getData();
                        if (data != null) {
                            HomeActivity homeActivity = HomeActivity.this;
                            if (data.isEmpty()) {
                                activityHomeBinding6 = homeActivity.binding;
                                if (activityHomeBinding6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                    activityHomeBinding6 = null;
                                }
                                TextView tvEmpty = activityHomeBinding6.tvEmpty;
                                Intrinsics.checkNotNullExpressionValue(tvEmpty, "tvEmpty");
                                ExtensionKt.visible(tvEmpty);
                                activityHomeBinding7 = homeActivity.binding;
                                if (activityHomeBinding7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityHomeBinding8 = activityHomeBinding7;
                                }
                                RecyclerView rvList = activityHomeBinding8.rvList;
                                Intrinsics.checkNotNullExpressionValue(rvList, "rvList");
                                ExtensionKt.gone(rvList);
                                return;
                            }
                            activityHomeBinding4 = homeActivity.binding;
                            if (activityHomeBinding4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                activityHomeBinding4 = null;
                            }
                            TextView tvEmpty2 = activityHomeBinding4.tvEmpty;
                            Intrinsics.checkNotNullExpressionValue(tvEmpty2, "tvEmpty");
                            ExtensionKt.gone(tvEmpty2);
                            activityHomeBinding5 = homeActivity.binding;
                            if (activityHomeBinding5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                activityHomeBinding8 = activityHomeBinding5;
                            }
                            RecyclerView rvList2 = activityHomeBinding8.rvList;
                            Intrinsics.checkNotNullExpressionValue(rvList2, "rvList");
                            ExtensionKt.visible(rvList2);
                            gameAdapter = homeActivity.getGameAdapter();
                            gameAdapter.sendData(data);
                        }
                    } else if (resource instanceof Resource.Error) {
                        activityHomeBinding2 = HomeActivity.this.binding;
                        if (activityHomeBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityHomeBinding8 = activityHomeBinding2;
                        }
                        ProgressBar progressbar2 = activityHomeBinding8.progressbar;
                        Intrinsics.checkNotNullExpressionValue(progressbar2, "progressbar");
                        ExtensionKt.gone(progressbar2);
                        Toast.makeText(HomeActivity.this, resource.getMessage(), 0).show();
                    } else if (resource instanceof Resource.Loading) {
                        activityHomeBinding = HomeActivity.this.binding;
                        if (activityHomeBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityHomeBinding8 = activityHomeBinding;
                        }
                        ProgressBar progressbar3 = activityHomeBinding8.progressbar;
                        Intrinsics.checkNotNullExpressionValue(progressbar3, "progressbar");
                        ExtensionKt.visible(progressbar3);
                    }
                }
            }
        }));
    }
}