class MessageModel {

    private String userId;
    private int type;

    public MessageModel(String id, int type) {

        this.userId = id;
        this.type = type;
    }
    
    public String getUserId() { return userId; }
    public int getType() { return type; }
}

class Solution {

    private static final String[] messages =
    { "님이 들어왔습니다.", "님이 나갔습니다." };

    private static final int ENTER_TYPE = 0;
    private static final int LEAVE_TYPE = 1;

    private static final String ENTER_ACTION = "Enter";
    private static final String LEAVE_ACTION = "Leave";
    private static final String CHANGE_ACTION = "Change";

    public String[] solution(String[] record) {

        final java.util.Map<String, String> usernames
            = new java.util.HashMap<>();
        final java.util.List<MessageModel> messageModels
            = new java.util.LinkedList<>();

        for (String r: record) {

            final String[] s = r.split(" ");
            final String action = s[0];
            final String userId = s[1];
            final String username = s.length<3? null: s[2];

            switch (action) {
                case ENTER_ACTION:
                    usernames.put(userId, username);
                    messageModels.add(new MessageModel(userId,ENTER_TYPE));
                    break;
                case LEAVE_ACTION:
                    messageModels.add(new MessageModel(userId,LEAVE_TYPE));
                    break;
                case CHANGE_ACTION:
                    usernames.put(userId, username);
                    break;
            }
        }

        return messageModels
            .stream()
            .map(model -> usernames.get(model.getUserId())+messages[model.getType()])
            .toArray(String[]::new);
    }
}
