//观察者模式

import java.util.ArrayList;

// Subject 主题接口
interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyAllObservers();
}

// 观察者接口
interface Observer {
    public void update(Subject s);
}

//视频网站某狐 实现 Subject 接口
class VideoSite implements Subject{

	// 观察者列表 以及 更新了的视频列表
	private ArrayList<Observer> userList;
	private ArrayList<String> videos;

	public VideoSite(){
		userList = new ArrayList<Observer>();
		videos = new ArrayList<String>();
	}

	@Override
	public void registerObserver(Observer o) {
		userList.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		userList.remove(o);
	}

	@Override
	public void notifyAllObservers() {
		for (Observer o: userList) {
			o.update(this);
		}
	}

	public void addVideos(String video) {
		this.videos.add(video);
		notifyAllObservers();
	}

	public ArrayList<String> getVideos() {
		return videos;
	}

	public String toString(){
		return videos.toString();
	}
}

//实现观察者，即看视频的美剧迷们
class VideoFans implements Observer {

	private String name;

	public VideoFans(String name){
		this.name = name;
	}
	@Override
	public void update(Subject s) {
		System.out.println(this.name + ", new videos are available! ");
		// print video list
		System.out.println(s);
	}
}

public class ObserverTest {

	public static void main(String[] args) {
        VideoSite vs = new VideoSite();
        vs.registerObserver(new VideoFans("LiLei"));
        vs.registerObserver(new VideoFans("HanMeimei"));
        vs.registerObserver(new VideoFans("XiaoMing"));

        // add videos
        vs.addVideos("Video 1");
        //vs.addVideos("Video 2");
	}

}
