# Android Push Notifications with Firebase Cloud Messaging and [PubNub](https://www.pubnub.com/?devrel_gh=android-push-notifications).

When building mobile applications in Android (and mobile applications in general), it is tough to think of a use case where you don’t need to communicate with mobile devices to sync data and notify users. For example, let’s consider the following scenario. You are developing a realtime sports application which feeds its users with critical news during a game. A key feature to the app would be to send reliable push notifications to the users as soon as their favorite team scores.

<a href="https://www.pubnub.com/products/mobile-push-notifications/?devrel_gh=android-push-notifications" target="_blank" rel="noopener"><img align="right" src="/poweredbypubnub_325.gif" alt="Push Notification Powered By PubNub" width="325" height="577" /></a>

## How is PubNub Used With Push Notifications?
If you are using PubNub Data Streams, you are already communicating in realtime with all of your devices – but if you want to send push notifications for a native Android experience, FCM is a great ally.

If your application is destined for multiple platforms, the PubNub SDK makes your life easier by supporting Apple Push Notification Service (APNs) and FCM out of the box. Even if you don’t support multiple platforms yet, using the PubNub support for FCM will streamline your code by using a single set of libraries for PubNub Data Streams as well as FCM notifications.

PubNub has an easy integration with FCM. A PubNub channel replaces the third party servers which send these notifications to Google’s FCM servers. You may have any registered endpoint send a push notification to your connected devices.

This allows the application to send push notifications to devices registered on specific channels in no time. It combines the native Android Notification API from Google with the realtime data stream network of PubNub. Your notifications will be natively understood by any Android device. If you already have FCM on your application and are considering using PubNub, you’ll hardly have to change anything about your app, most likely removing code!

Going back to the sports news app scenario, you can have your sports critic send the score in realtime from his phone and trigger a push notification to the rest of the audience’s devices. PubNub makes it simple – additional servers that you have to operate can be ruled out of the equation!

This project demonstrates how to setup FCM push notifications, enable PubNub push notifications, and configure the [PubNub Android SDK](https://www.pubnub.com/docs/android-java/pubnub-java-sdk?devrel_gh=android-push-notifications) to receive push notifications. Learn more about how to get started with FCM push notifications powered by PubNub from the tutorial (coming soon).

<a href="https://www.pubnub.com/blog/?devrel_gh=android-push-notifications">
    <img alt="PubNub Blog" src="https://i.imgur.com/aJ927CO.png" width=260 height=98/>
</a>

## Sending Push Notifications From PubNub
<a href="https://www.pubnub.com/products/mobile-push-notifications/?devrel_gh=android-push-notifications" target="_blank" rel="noopener"><img align="right" src="https://www.pubnub.com/blog/wp-content/uploads/2018/10/debugclient.png" alt="PubNub Debug Client" width="244" height="350" /></a>

It’s important to note that the devices don’t need to subscribe to a channel to receive notifications for that channel. The devices only need to register to the channel for push notifications and then they will receive push notifications for any messages that have push notifications keys for that device type.

* Associated FCM devices will receive only the data within the <code>pn_gcm</code> key.
* Native PubNub subscribers will receive the entire object literal, including the notification keys.

In this app the device is registered to the "Notifications" channel. Any messages sent to that channel with <code>pn_gcm</code> keys will be sent as a push notification to registered devices.

The easiest way to test push notifications is to send them from the PubNub Debug Console from within the <a href="https://admin.pubnub.com/?devrel_gh=android-push-notifications" target="_blank" rel="noopener">PubNub Admin Dashboard</a>.

Go to your <a href="https://admin.pubnub.com/?devrel_gh=android-push-notifications" target="_blank" rel="noopener">PubNub Admin Dashboard</a>, select your app, and then select your keyset.

Click “Debug Console” and create a client with “Default Channel” set to <code>Notifications</code>.

With the client you just created you can send a notification to your device by sending a message containing the <code>pn_gcm</code> keys.

Send an Android push notification: <code>{"pn_gcm":{"notification":{"body":"Hello World."}}}</code><span class="aligncenter">

Refer to the <a href="https://support.pubnub.com/support/solutions/articles/14000043605-how-can-i-troubleshoot-my-push-notification-issues-?devrel_gh=android-push-notifications" target="_blank" rel="noopener">troubleshooting guide</a> if you have issues sending push notifications.

<strong>Have suggestions or questions about the content of this post? Reach out at <a href="mailto:devrel@pubnub.com" target="_blank" rel="noopener" data-rawhref="mailto:devrel@pubnub.com">devrel@pubnub.com</a>.</strong>

