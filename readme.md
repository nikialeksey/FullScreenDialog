[![BCH compliance](https://bettercodehub.com/edge/badge/nikialeksey/FullScreenDialog?branch=master)](https://bettercodehub.com/)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/94dcc0c5d12d4c2d9aba648f0d705f60)](https://www.codacy.com/app/nikialeksey/FullScreenDialog?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=nikialeksey/FullScreenDialog&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/c0fcacc7-3aac-4c7b-8283-aa8f9e284e81)](https://codebeat.co/projects/github-com-nikialeksey-fullscreendialog-master)
[![codecov](https://codecov.io/gh/nikialeksey/FullScreenDialog/branch/master/graph/badge.svg)](https://codecov.io/gh/nikialeksey/FullScreenDialog)
[![Build Status](https://travis-ci.org/nikialeksey/FullScreenDialog.svg?branch=master)](https://travis-ci.org/nikialeksey/FullScreenDialog)
[![Dependency Status](https://www.versioneye.com/user/projects/5979d857368b080066d28d11/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/5979d857368b080066d28d11)
[![0pdd](http://www.0pdd.com/svg?name=nikialeksey/FullScreenDialog)](http://www.0pdd.com/p?name=nikialeksey/FullScreenDialog)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/nikialeksey/FullScreenDialog/blob/master/LICENSE)
[![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![Download](https://api.bintray.com/packages/pidra/maven/full-screen-dialog/images/download.svg)](https://bintray.com/pidra/maven/full-screen-dialog/_latestVersion)

# FullScreenDialog
Implementation of [full-screen-dialogs](https://material.io/guidelines/components/dialogs.html#dialogs-full-screen-dialogs) 
from material guidelines.

![Video description](https://github.com/nikialeksey/FullScreenDialog/blob/master/gifs/main.gif)

### Add to project
```gradle
repositories {
    jcenter()
}

dependencies {
    ...
    compile('com.nikialeksey:fullscreendialog:<latest version>@aar') {
        transitive true
    }
    ...
}
```

### Usage
```java
new FsDialog(context, R.style.AppTheme, "Title", new FsDialogCloseAction() {
    @Override
    public void onClose(@NonNull final FsDialog dialog) {
// close action
    }
}, "Action Title", new FsDialogAction() {
    @Override
    public void onClick(@NonNull final FsDialog dialog) {
//  base action        
    }
}, contentView).show();
```