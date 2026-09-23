public class PlayerAdapter implements Player{
    private OldPlayer oldplayer ;
    public PlayerAdapter(OldPlayer oldplayer) {this.oldplayer = oldplayer;}
    @Override
    public void play(String name) {
        oldplayer.playFile(name);
    }
}
